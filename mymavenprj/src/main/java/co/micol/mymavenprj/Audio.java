package co.micol.mymavenprj;

import javax.sound.sampled.*; //샘플화 된 오디오 데이터의 수중에 넣어, 처리 및 재원시인터페이스 및 클래스를 제공
import java.io.File; //파일 시스템의 파일 정보를 얻기 위한 클래스
import java.io.IOException; //I/O 오류가 발생하는 경우에 throw되는 예외

public class Audio {

	private Clip clip;
	private File audioFile;
	private AudioInputStream audioInputStream;
	private boolean isLoop;

	public Audio(String pathName, boolean isLoop) { // 생성자의 매개변수(파일의 경로,무한반복 여부)
		try {
			clip = AudioSystem.getClip(); // 오디오 재생에 사용할 수 있는 클립
			audioFile = new File(pathName);
			audioInputStream = AudioSystem.getAudioInputStream(audioFile); // 경로명에 있는 파일로부터 오디오 입력 스트림을 가져옴
			clip.open(audioInputStream); // 클립에 오디오 입력 스트림을 받아옴
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}

	public void start() { // cilp을 재생 할 수 있는 메소드
		clip.setFramePosition(0); // 클립이 파일의 처음을 가르키게 하고 재생
		clip.start();
		if (isLoop)
			clip.loop(Clip.LOOP_CONTINUOUSLY); // 생성자에서 받아온 무한반복여부를 통해 무한반복일 경우도 구현
	}

	public void stop() { // 재생하고있는 파일을 멈추는 메소드
		clip.stop();
	}

}

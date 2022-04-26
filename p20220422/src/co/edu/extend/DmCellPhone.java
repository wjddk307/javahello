package co.edu.extend;
//자식클래스
public class DmCellPhone extends CellPhone {
	//필드
	public int channel;
	//생성자
	public CellPhone(String model, String color, int chnnel) {
		super(model, color);
		this.channel = channel;
	}
	//메소드
    void turnOnDmd
}
@Override
void PowerOn() {
	System.out.println("자식 클래스에서 전원을 킵니다.");
}
package data.com;

public class Data {
	private float f1;
	private float f2;
	private float f3;
	private float f4;
	private int c1;
	private int c2;
	private int c3;
	public Data(float f1, float f2, float f3, float f4, int c1, int c2, int c3) {
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}
	public float getF1() {
		return f1;
	}
	public void setF1(float f1) {
		this.f1 = f1;
	}
	public float getF2() {
		return f2;
	}
	public void setF2(float f2) {
		this.f2 = f2;
	}
	public float getF3() {
		return f3;
	}
	public void setF3(float f3) {
		this.f3 = f3;
	}
	public float getF4() {
		return f4;
	}
	public void setF4(float f4) {
		this.f4 = f4;
	}
	public int getC1() {
		return c1;
	}
	public void setC1(int c1) {
		this.c1 = c1;
	}
	public int getC2() {
		return c2;
	}
	public void setC2(int c2) {
		this.c2 = c2;
	}
	public int getC3() {
		return c3;
	}
	public void setC3(int c3) {
		this.c3 = c3;
	}
	
	@Override
	public String toString() {
		return getF1() + " " + getF2() + " " + getF3() + " " + getF4() + " " + getC1() + " " + getC2() + " " + getC3();
	}
	
}

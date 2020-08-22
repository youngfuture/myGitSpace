package ex9.stream.test;

public class Student {
	

	private String name;
	private int height;
	private String sex;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student( String name, int height,String sex) {
		this.sex = sex;
		this.name = name;
		this.height = height;
	}
}

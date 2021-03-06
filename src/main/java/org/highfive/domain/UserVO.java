package org.highfive.domain;

public class UserVO extends PageVO{

	private String uid;
	private String uname;
	private int age;
	private String nation;
	private int sex; //0:woman, 1:man
	private String uphoto;
	private String email;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", uname=" + uname + ", age=" + age + ", nation=" + nation
				+ ", sex=" + sex + ", uphoto=" + uphoto + ", email=" + email + "]";
	}
}

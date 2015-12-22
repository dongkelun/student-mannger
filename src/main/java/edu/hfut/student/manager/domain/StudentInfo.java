package edu.hfut.student.manager.domain;

import java.io.Serializable;

/**
 * 学生信息
 *
 * @author dkl
 *
 */
public class StudentInfo implements Serializable {

	private static final long serialVersionUID = 9072076688057350231L;

	private int sid;
	private String name;
	private String birthday;
	private String gender;
	private int age;
	private String resume;
	private String awards;
	private String penality;
	private String home;
	private String medical;

	public StudentInfo() {
		super();
	}

	public StudentInfo(Builder builder) {
		this.sid = builder.sid;
		this.name = builder.name;
		this.birthday = builder.birthday;
		this.gender = builder.gender;
		this.age = builder.age;
		this.resume = builder.resume;
		this.awards = builder.awards;
		this.penality = builder.penality;
		this.home = builder.home;
		this.medical = builder.medical;
	}

	@Override
	public String toString() {
		return "StudentInfo [sid=" + sid + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender
				+ ", age=" + age + ", resume=" + resume + ", awards=" + awards + ", penality=" + penality + ", home="
				+ home + ", medical=" + medical + "]";
	}

	public Object[] getData() {
		return new Object[] { getSid(), getName(), getBirthday(), getGender(), getAge(), getResume(), getAwards(),
				getPenality(), getHome(), getMedical() };
	}

	public static class Builder {

		private int sid;
		private String name;
		private String birthday;
		private String gender;
		private int age;
		private String resume = "";
		private String awards = "";
		private String penality = "";
		private String home = "";
		private String medical = "";

		public Builder(int sid, String name, String birthday, String gender, int age) {
			super();
			this.sid = sid;
			this.name = name;
			this.birthday = birthday;
			this.gender = gender;
			this.age = age;
		}

		public Builder setResume(String resume) {
			this.resume = resume;
			return this;
		}

		public Builder setAwards(String awards) {
			this.awards = awards;
			return this;
		}

		public Builder setPenality(String penality) {
			this.penality = penality;
			return this;
		}

		public Builder setHome(String home) {
			this.home = home;
			return this;
		}

		public Builder setMedical(String medical) {
			this.medical = medical;
			return this;
		}

		public StudentInfo build() {
			return new StudentInfo(this);
		}

	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPenality() {
		return penality;
	}

	public void setPenality(String penality) {
		this.penality = penality;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getMedical() {
		return medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

}

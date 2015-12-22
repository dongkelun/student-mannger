package edu.hfut.student.manager.domain;

import java.io.Serializable;

/**
 * 学生成绩信息
 *
 * @author dkl
 *
 */
public class StudentMark implements Serializable {

	private static final long serialVersionUID = -5458604594954315709L;

	private int sid;
	private int term;
	private String grade;
	private String major;
	private int course_id;
	private String course_name;
	private int score;

	public StudentMark() {
		super();
	}

	public StudentMark(Builder builder) {
		this.sid = builder.sid;
		this.term = builder.term;
		this.grade = builder.grade;
		this.major = builder.major;
		this.course_id = builder.course_id;
		this.course_name = builder.course_name;
		this.score = builder.score;
	}

	@Override
	public String toString() {
		return "StudentMark [sid=" + sid + ", term=" + term + ", grade=" + grade + ", major=" + major + ", course_id="
				+ course_id + ", course_name=" + course_name + ", score=" + score + "]";
	}

	public Object[] getData() {
		return new Object[] { getSid(), getTerm(), getGrade(), getMajor(), getCourse_id(), getCourse_name(), getScore() };
	}

	public static class Builder {

		private int sid;
		private int term;
		private String grade;
		private String major = "";
		private int course_id;
		private String course_name = "";
		private int score;

		public Builder(int sid, int term, String grade) {
			super();
			this.sid = sid;
			this.term = term;
			this.grade = grade;
		}

		public Builder setCourse_id(int course_id) {
			this.course_id = course_id;
			return this;
		}

		public Builder setMajor(String major) {
			this.major = major;
			return this;
		}

		public Builder setCourse_name(String course_name) {
			this.course_name = course_name;
			return this;
		}

		public Builder setScore(int score) {
			this.score = score;
			return this;
		}

		public StudentMark build() {
			return new StudentMark(this);
		}

	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

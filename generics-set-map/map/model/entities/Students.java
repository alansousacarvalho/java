package model.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Students {
	private Integer student;
	Set<Students> setStudents = new HashSet<>();

	public Students() {
	}

	public Students(Integer student) {
		this.student = student;
	}

	public Integer getStudent() {
		return student;
	}

	public void setStudent(Integer student) {
		this.student = student;
	}
	

	public Set<Students> getSetStudents() {
		return setStudents;
	}

	public void addStudent(Integer student) {
		setStudents.add(new Students(student));
	}

	@Override
	public int hashCode() {
		return Objects.hash(student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return Objects.equals(student, other.student);
	}

}


//Author: Kam Bee Foong

package entity;

import adt.MapInterface;
import adt.TreeMap;
import java.util.Objects;

public class TutorialGroup {
	private final String groupID;
	private final String facultyName;
	private final String programmeName;
	private MapInterface<String, Student> studentMap;

	public TutorialGroup(String groupID, String facultyName, String programmeName) {
		this.groupID = groupID;
		this.facultyName = facultyName;
		this.programmeName = programmeName;
		this.studentMap = new TreeMap<>(); // Assuming you have a TreeMap implementation for students
	}

	public String getGroupID() {
		return groupID;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public String getProgrammeName() {
		return programmeName;
	}

	public void addStudent(Student student) {
		String studentID = student.getStudentID();

		studentMap.put(studentID, student);
	}

	public void removeStudent(String studentID) {
		studentMap.remove(studentID);
	}

	public boolean containsStudent(String studentID) {
		return studentMap.contains(studentID);
	}

	public Student findStudent(String studentID) {
		return studentMap.get(studentID);
	}

	public int getNumberOfStudents() {
		return studentMap.size();
	}

	public MapInterface<String, Student> getTutorialGroup() {
		return studentMap;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		TutorialGroup tutorialGroup = (TutorialGroup) obj;
		return groupID.equals(tutorialGroup.groupID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupID);
	}

	@Override
	public String toString() {
		return "Tutorial Group ID: " + groupID + ", Faculty Name: " + facultyName + ", Programme: " + programmeName;
	}
}
/**
 * Student class contains roll number and name and Marks of the Student.
 * 
 */
class Student {
	/**
	 * rollno of the Student.
	 */
	private String rollno;
	/**
	 * Name of the Student.
	 */
	private String name;
	/**
	 * Total marks of the student.
	 */
	private Double marks;
	/**
	 * Constructs the object for Student.
	 *
	 * @param      roll    The roll of the Student.
	 * @param      name1   The name of the Student.
	 * @param      marks1  The marks of the Student.
	 */
	Student(final String roll, final String name1, final Double marks1) {
		this.rollno = roll;
		this.name = name1;
		this.marks = marks1;
	}
	String getRoll() {
		return this.rollno;
	}
	String getName() {
		return this.name;
	}
	Double getMarks() {
		return this.marks;
	}

}
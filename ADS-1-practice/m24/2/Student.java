/**
 * Student class contains roll number and name and Marks of the Student.
 */
class Student implements Comparable<Student> {
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
    /**
     * Gets the roll number of the Student.
     *
     * @return     The roll.
     */
    public String getRoll() {
        return this.rollno;
    }
    /**
     * Gets the name of the Student.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the Total marks of the Student.
     *
     * @return     The marks.
     */
    public Double getMarks() {
        return this.marks;
    }
    /**
     * compareTo method comapares the two students.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student s) {
        if (this.marks > s.marks) {
            return 1;
        }
        if (this.marks < s.marks) {
            return -1;
        }
        return this.rollno.compareTo(s.rollno);
    }

}

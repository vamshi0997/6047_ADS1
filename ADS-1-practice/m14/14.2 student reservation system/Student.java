/**
 * Student class contain Student details and other methods.
 */
class Student implements Comparable<Student> {
    /**
     * student name contains name of student.
     */
    private String studentName;
    /**
     * dob contains date of birth.
     */
    private String dob;
    /**
     * it contains dob string.
     */
    private String[] ndob = null;
    /**
     * it contains date.
     */
    private int date = 0;
    /**
     * It contains month.
     */
    private int month = 0;
    /**
     * It contains year.
     */
    private int year = 0;
    /**
     * It contains subject1 marks.
     */
    private int subject1;
    /**
     * It contains subject2 marks.
     */
    private int subject2;
    /**
     * It contains subject3 marks.
     */
    private int subject3;
    /**
     * It contains subject3 marks.
     */
    private int total;
    /**
     * it contains reservation category.
     */
    private String reservationcat;
    /**
     * Student constructor.
     *
     * @param name name.
     * @param dob1 dob.
     * @param sub1 sub1
     * @param sub2 sub2.
     * @param sub3 sub3
     * @param tot tot.
     * @param res res.
     */
    Student(final String name, final String dob1, final int sub1,
        final int sub2, final int sub3, final int tot, final String res) {
        this.studentName = name;
        this.dob = dob1;
        this.ndob = dob1.split("-");
        this.date = Integer.parseInt(ndob[0]);
        this.month = Integer.parseInt(ndob[1]);
        this.year = Integer.parseInt(ndob[2]);
        this.subject1 = sub1;
        this.subject2 = sub2;
        this.subject3 = sub3;
        this.total = tot;
        this.reservationcat = res;

    }
    /**
     * Name of Student.
     * @return name.
     */
    public String getName() {
        return this.studentName;
    }
    /**
     * get total marks.
     * @return int.
     */
    public int getTot() {
        return this.total;
    }
    /**
     * get reservation category.
     * @return category.
     */
    public String getCat() {
        return this.reservationcat;
    }
    /**
     * comapares the required parameters in student.
     *
     * @param stud Student.
     * @return int value.
     */
    public int compareTo(final Student stud) {
        if (this.total > stud.total) {
            return 1;
        }
        if (this.total < stud.total) {
            return -1;
        }
        if (this.subject3 > stud.subject3) {
            return 1;
        }
        if (this.subject3 < stud.subject3) {
            return -1;
        }
        if (this.subject2 > stud.subject2) {
            return 1;
        }
        if (this.subject2 < stud.subject2) {
            return -1;
        }
        if (this.year > stud.year) {
            return 1;
        }
        if (this.year < stud.year) {
            return -1;
        }
        if (this.month > stud.month) {
            return 1;
        }
        if (this.month < stud.month) {
            return -1;
        }
        if (this.date > stud.date) {
            return 1;
        }
        if (this.date < stud.date) {
            return -1;
        }
        return 0;
    }
}

/**
 * Student class contain Student details and other methods.
 */
class Student implements Comparable<Student>{
	private String studentName;
	private String dob;
	private int subject1;
	private int subject2;
	private int subject3;
	private int total;
	private String reservationcat;

	Student(final String name, final String dob1, final int sub1,
		final int sub2, final int sub3, final int tot, final String res) {
		this.studentName = name;
		this.dob = dob1;
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
		this.total = tot;
		this.reservationcat = res;

	}

	public String getName() {
		return this.studentName;
	}

	public int getTot() {
        return this.total;
	}

	public String getCat() {
		return this.reservationcat;
	}

	public int compareTo(Student stud) {
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
		return 0;
	}

}
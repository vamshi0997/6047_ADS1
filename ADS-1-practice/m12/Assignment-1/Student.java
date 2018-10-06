/**
 * Student class contain Student details and other methods.
 */
class Student implements Comparable<Student>{
	private String studentName;
	private String dob;
	String[] ndob = null;
	private int date = 0;
	private int month = 0;
	private int year = 0;
	private int subject1;
	private int subject2;
	private int subject3;
	private int total;
	private String reservationcat;

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

	// static Comparator<Student> merit = new Comparator<Student>(){
	// 	public int compare(Student s1, Student s2) {
	// 		if (s1.total - s2.total != 0) {
	// 			return s1.total - s2.total;
	// 		} else if(s1.subject3 -s2.subject3 != 0) {
 //                return s1.subject3 -s2.subject3;
	// 		} else if(s1.subject2 -s2.subject2 != 0) {
	// 			return;
	// 		}
	// 	}
	// };

	// static Comparator<Student> reserve = new Comparator<Student>(){
	// 	public int compare(Student s1, Student s2) {
	// 		if (s1.total - s2.total != 0) {
	// 			return s1.total - s2.total;
	// 		}
	// 	}
	// };

	public String toString() {
        return this.studentName + ","
        + this.total + "," + this.reservationcat;
	}



}
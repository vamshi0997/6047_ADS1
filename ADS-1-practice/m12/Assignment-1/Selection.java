class Selection {
	private Student[] nstudent;
	private int size;
	Selection() {
		nstudent = new Student[100];
		size = 0;
	}
	public void add(Student stud) {
		nstudent[size++] = stud;
	}

	public String sort() {
		String s = "";
		SeletionSort s1 = new SeletionSort();
		Student[] stud = s1.sort(nstudent, size);
		for (int i = 0; i < size; i++) {
			s += stud[i].getName()+","+stud[i].getTot()+","+stud[i].getCat() + " \n";
		}
		return s.substring(0, s.length() - 1);
	}

	public String sort1(int vacancies, int unreserved, int bcvacancies, int scvacancies, int stvancancies) {
		String s = "";
		SeletionSort s1 = new SeletionSort();
		Student[] stud = s1.sort(nstudent, size);
		for (int i = 0; i < unreserved; i++) {
                s += stud[i].getName()+","+stud[i].getTot()+","+stud[i].getCat() + " \n";
			}
        for (int j = 0; j < vacancies; j++) {
        	    if(stud[j].getCat().equals("ST") && s.contains(stud[j].getName()))
                s += stud[j].getName()+","+stud[j].getTot()+","+stud[j].getCat() + " \n";
			}
		return s.substring(0, s.length() - 1);
	}



}

// class Insertion{

// 	public Insertion() {}

// 	public static Object sort(Object[] a, Comparator comparator) {
//         int n = a.length;
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j > 0 && less(a[j], a[j-1], comparator); j--) {
//                 exch(a, j, j-1);
//             }
//             // assert isSorted(a, 0, i, comparator);
//         }
//         // assert isSorted(a, comparator);
//     }


//     private static  boolean less(Object v, Object w, Comparator comparator) {
//         return comparator.compare(v, w) < 0;
//     }

//     private static void exch(Object[] a, int i, int j) {
//         Object swap = a[i];
//         a[i] = a[j];
//         a[j] = swap;
//     }
// }

class SeletionSort {
    // /**
    //  * sort is used to sort elements.
    //  *
    //  * @param team is team array ehich has team objects.
    //  * @param size gives team array size.
    //  *
    //  * @return the team array which is sorted.
    //  */
	public Student[] sort(Student[] select, int size) {
		for(int i = 0; i < size - 1; i++) {
			int temp = i;
			for(int j = i+1; j < size; j++) {
               if (less(select, j, temp)) {
					temp = j;
				}
			}
			exchange(select, i, temp);
		}
        return select;
	}
	/**
	 *less method is used to make use of compareTo
	 *inorder to differentiate the which is less. 
	 * 
	 * @param team contains team elements.
	 * @param first element in the team array that is to be replaced.
	 * @param next element which is compared to first.
	 * @return true or false.
	 */
	public boolean less(Student[] select, int first, int next) {
		return  select[first].compareTo(select[next]) > 0;
	}
	/**
	 * exchange method is used to
	 * swap element with next lowest element in array.
	 *
	 * @param team array contain team elements.
	 * @param first element in the team array that is to be replaced.
	 * @param next element which is compared to first.
	 */
	public void exchange(Student[] select, int first, int next) {
		Student ct = select[next];
		select[next] = select[first];
		select[first] = ct;
	}   
}
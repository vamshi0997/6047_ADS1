class Selection {
	private Student[] nstudent;
	private int size;
	Selection() {
		nstudent = new Student[20];
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
			s += stud[i].getName()+","+stud[i].getTot()+","+stud[i].getCat();
		}
		return s.substring(0, s.length() - 1);
	}

}

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
	public boolean less(Selection[] select, int first, int next) {
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
	public void exchange(Selection[] select, int first, int next) {
		Student ct = select[next];
		select[next] = select[first];
		select[first] = ct;
	}   
}
/**
 * Selecton class.
 */
class Selection {
    /**
     * student array.
     */
    private Student[] nstudent;
    /**
     * student array.
     */
    private Student[] stud1;
    /**
     * size variable.
     */
    private int size;
    /**
     * size1 variable.
     */
    private int size1;
    /**
     * consatant variable.
     */
    private final int hundred = 100;
    /**
     * selection constructor.
     */
    Selection() {
        nstudent = new Student[hundred];
        stud1 = new Student[hundred];
        size = 0;
        size1 = 0;
    }
    /**
     * adding student element.
     *
     * @param stud stident.
     */
    public void add(final Student stud) {
        nstudent[size++] = stud;
    }
    /**
     * Sort the given array.
     * @return String.
     */
    public String sort() {
        String s = "";
        SeletionSort s1 = new SeletionSort();
        Student[] stud = s1.sort(nstudent, size);
        for (int i = 0; i < size; i++) {
            s += stud[i].getName() + ","
            + stud[i].getTot() + "," + stud[i].getCat() + "\n";
        }
        return s.substring(0, s.length() - 1);
    }
    /**
     * sort the given array.
     *
     * @param vacancies vacancies.
     * @param unreserved unreserved.
     * @param bcvacancies bcvacancies.
     * @param scvacancies scvacancies.
     * @param stvancancies stvacancies.
     * @return String.
     */
    public String sort1(final int vacancies, final int unreserved,
        final int bcvacancies, final int scvacancies, final int stvancancies) {
        String str = "";
        String str1 = "";
        SeletionSort s2 = new SeletionSort();
        Student[] stud = s2.sort(nstudent, size);
        int count1 = 0;
        for (int i = 0; i < unreserved; i++) {
                str += stud[i].getName() + "," + stud[i].getTot()
                + "," + stud[i].getCat() + "\n";
                str1 += stud[i].getName() + "," + stud[i].getTot()
                + "," + stud[i].getCat() + "\n";
                count1++;
            }
        int count = 1;
        for (int j = 0; j < size; j++) {
                if (stud[j].getCat().equals("BC")
                    && !str.contains(stud[j].getName())
                    && count <= bcvacancies) {
                    stud1[size1++] = stud[j];
                    str += stud[j].getName() + ","
                    + stud[j].getTot() + "," + stud[j].getCat() + "\n";
                    count++;
                    count1++;
                }
        }
        count = 1;
        for (int j = 0; j < size; j++) {
                if (stud[j].getCat().equals("ST")
                    && !str.contains(stud[j].getName())
                    && count <= stvancancies) {
                    stud1[size1++] = stud[j];
                    str += stud[j].getName() + ","
                    + stud[j].getTot() + "," + stud[j].getCat() + "\n";
                    count++;
                    count1++;
                }
         }
        count = 1;
        for (int j = 0; j < size; j++) {
                if (stud[j].getCat().equals("SC")
                    && !str.contains(stud[j].getName())
                    && count <= scvacancies) {
                    stud1[size1++] = stud[j];
                    str += stud[j].getName() + ","
                    + stud[j].getTot() + "," + stud[j].getCat() + "\n";
                    count++;
                    count1++;
                }
            }
        for (int j = 0; j < size; j++) {
            if (!(str.contains(stud[j].getName()))
                && count1 < vacancies) {
                stud1[size1++] = stud[j];
                count1++;
            }
        }
        Student[] nstud = s2.sort(stud1, size1);
        for (int j = 0; j < size1; j++) {
            str1 += nstud[j].getName() + ","
            + nstud[j].getTot() + "," + nstud[j].getCat() + "\n";

        }
        return str1.substring(0, str1.length() - 1);
    }
}
/**
 * Selection sort contain sort method.
 */
class SeletionSort {
    /**
     * sort is used to sort elements.
     *
     * @param select is team array ehich has team objects.
     * @param size gives team array size.
     *
     * @return the team array which is sorted.
     */
    public Student[] sort(final Student[] select, final int size) {
        for (int i = 0; i < size - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < size; j++) {
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
     * @param select contains team elements.
     * @param first element in the team array that is to be replaced.
     * @param next element which is compared to first.
     * @return true or false.
     */
    public boolean less(final Student[] select,
        final int first, final int next) {
        return  select[first].compareTo(select[next]) > 0;
    }
    /**
     * exchange method is used to
     * swap element with next lowest element in array.
     *
     * @param select array contain team elements.
     * @param first element in the team array that is to be replaced.
     * @param next element which is compared to first.
     */
    public void exchange(final Student[] select,
        final int first, final int next) {
        Student ct = select[next];
        select[next] = select[first];
        select[first] = ct;
    }
}

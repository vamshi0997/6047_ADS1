/**
 * Team class contains team variables.
 */
class Team implements Comparable<Team> {
	/**
	 * stores the team name.
	 */
	private String teamname;
	/**
	 * store the wins in integer format.
	 */
	private int wins;
	/**
	 * store the draws in integer format.
	 */
	private int draws;
	/**
	 * store the losses in integer format.
	 */
	private int losses;
	/**
	 * Team construtor.
	 */
	Team(final String teamname1, final int wins1, final int losses1, final int draws1) {
		this.teamname = teamname1;
		this.wins = wins1;
		this.draws = draws1;
		this.losses = losses1;
	}
    /**
     * gives team name.
     */
	public String getTeam() {
		return this.teamname; 
	}
	/**
	 * gives team wins.
	 */
	public int getWin() {
		return this.wins;
	}
	/**
	 * gives team draws.
	 */
	public int getDraw() {
		return this.draws;
	}
	/**
	 * gives the team losses.
	 */
	public int getLose() {
		return this.losses;
	}
	/**
	 * gives the team name.
	 */
	public String toString() {
		return this.teamname;
	}
	/**
	 * compare method is used to
	 * compare elements in team array acoording to given variables.
	 */
	public int compareTo(Team team) {
		if (this.wins > team.wins) {
			return 1;
		}
		if (this.wins < team.wins) {
			return -1;
		}
		if (this.losses > team.losses) {
			return -1;
		}
		if (this.losses < team.losses) {
			return 1;
		}
		if (this.draws > team.draws) {
			return 1;
		}
		if (this.draws < team.draws) {
			return -1;
		}
		return 0;  
	}
}
/**
 * Teams class is used to store the team objects in an array.
 */
class Teams {
	/**
	 * store team elements in array.
	 */
	private Team[] team1;
	/**
	 * store sizeof team array.
	 */
	public int size;
	/**
	 * Team constructor.
	 */
	Teams() {
		team1 = new Team[10];
		size = 0;
	}
	/**
	 * Time complexity is O(1).
	 * add team elements in array.
	 *
	 * @param team contains team objects.
	 */
	public void add(final Team team) {
        team1[size++] = team;
	}
    /**
     * Time complexity is O(N^2).
     * sort method is used to sort the team object by sending it to selection sort.
     * @return the string contains team name in order.
     */
	public String sort() {
		String s = "";
		SeletionSort s1 = new SeletionSort();
		Team[] team2 = s1.sort(team1, size);
		for (int i = 0; i < size; i++) {
			s += team2[i].getTeam()+",";
		}
		return s.substring(0, s.length() - 1);
	}
}
/**
 * Selectionsort class is used to sort the elements in array.
 * Here we have mehods like exchange, less methods.
 */
class SeletionSort {
    /**
     * Time complexity is O(N^2).
     * sort is used to sort elements.
     *
     * @param team is team array ehich has team objects.
     * @param size gives team array size.
     *
     * @return the team array which is sorted.
     */
	public Team[] sort(final Team[] team, final int size) {
		for(int i = 0; i < size - 1; i++) {
			int temp = i;
			for(int j = i+1; j < size; j++) {
               if (less(team, j, temp)) {
					temp = j;
				}
			}
			exchange(team, i, temp);
		}
        return team;
	}
	/**
	 * Time comlexity is O(1).
	 *less method is used to make use of compareTo
	 *inorder to differentiate the which is less. 
	 * 
	 * @param team contains team elements.
	 * @param first element in the team array that is to be replaced.
	 * @param next element which is compared to first.
	 * @return true or false.
	 */
	public boolean less(final Team[] team, final int first, final int next) {
		return  team[first].compareTo(team[next]) > 0;
	}
	/**
	 * Time complexity is O(1).
	 * exchange method is used to
	 * swap element with next lowest element in array.
	 *
	 * @param team array contain team elements.
	 * @param first element in the team array that is to be replaced.
	 * @param next element which is compared to first.
	 */
	public void exchange(fianl Team[] team, final int first, final int next) {
		Team ct = team[next];
		team[next] = team[first];
		team[first] = ct;
	}
}

import java.util.Scanner;
class Team implements Comparable<Team> {
	String teamname;
	int wins;
	int draws;
	int losses;
	Team(final String teamname1, final int wins1, final int draws1, final int losses1) {
		this.teamname = teamname1;
		this.wins = wins1;
		this.draws = draws1;
		this.losses = losses1;
	}

	String getTeam() {
		return this.teamname; 
	}

	int getWin() {
		return this.wins;
	}

	int getDraw() {
		return this.draws;
	}
	int getLose() {
		return this.losses;
	}

	public String toString() {
		return this.teamname;
	}


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

class Teams {
	Team[] team1;
	int size;
	Teams() {
		team1 = new Team[10];
		size = 0;
	}
	public void add(Team team) {
        team1[size++] = team;
	}

	public String sort() {
		String s = "";
		SeletionSort s1 = new SeletionSort();
		Team[] team2 = s1.sort(team1, size);
		for (int i = 0; i < size; i++) {
			s += team2[i].getTeam()+",";
		}
		return s.substring(0, s.length() - 1);
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += team1[i].getTeam()+",";
		}
		return s.substring(0, s.length() - 1);
	}
	public int getSize() {
		return size;
	}
}

class SeletionSort {
	Team[] sort(Team[] team, int size) {
		for(int i = 0; i < size; i++) {
			int temp = i;
			for(int j = i+1; j < size - 1; j++) {
               if (less(team, j, temp)) {
					temp = j;
				} 
			}
			exch(team, i, temp);
		}
        return team;
	}
	boolean less(Team[] arr, int i, int j) {
		return  arr[i].compareTo(arr[j]) > 0;
	}
	public void exch(Team[] teams, int i, int j) {
		Team ct = teams[j];
		teams[j] = teams[i];
		teams[i] = ct; 
	}   
}


public final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		Teams t1 = new Teams();
		Teams t2 = new Teams();
		SeletionSort s1 = new SeletionSort();
		while(scan.hasNext()) {
			String[] line = scan.nextLine().split(",");
			Team t = new Team(line[0], Integer.parseInt(line[1]),
				Integer.parseInt(line[2]), Integer.parseInt(line[3]));
			t1.add(t);
		}
		System.out.println(t1.sort());
	}
}
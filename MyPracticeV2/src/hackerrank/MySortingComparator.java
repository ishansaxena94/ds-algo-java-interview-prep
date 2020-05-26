package hackerrank;

import java.util.Comparator;

class Player {
	String name;
	int score;
}

class Checker implements Comparator<Player> {
	// complete this method
	public int compare(Player a, Player b) {
		int val = 0;

		val = Integer.compare(b.score, a.score);

		return (val == 0) ? a.name.compareTo(b.name) : val;
	}
}

public class MySortingComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

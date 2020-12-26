
public class Queen8 {

	static int solutionCount = 0;

	public static void getSolution(int n) {
		int[] queen = new int[n];
		backtrack(queen, 0);
	}

	public static void backtrack(int[] q, int row) {
		if (row == q.length) {
			solutionCount += 1;
			System.out.println("Solution" + solutionCount);
			printQueens(q);
		} else {
			for (int column = 0; column < q.length; column++) {
				q[row] = column;
				if (constraints(q, row, column)) {
					backtrack(q, row + 1);
				}
			}
		}
	}
	
	public static boolean constraints(int[] q, int row, int column) {
		for (int i = 0; i < row; i++) {
			if (q[i] == column)
				return false; // same column
			if ((q[i] - column) == (row - i))
				return false; // same right top to left bottom diagonal
			if ((column - q[i]) == (row - i))
				return false; // same left top to right bottom diagonal
		}
		return true;
	}

	public static void printQueens(int[] q) {
		for (int row = 0; row < q.length; row++) {
			for (int column = 0; column < q.length; column++) {
				if (q[row] == column)
					System.out.print("Q ");
				else
					System.out.print(". ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		getSolution(8);
	}
}

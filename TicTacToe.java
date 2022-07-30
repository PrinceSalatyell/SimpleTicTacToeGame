import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	
	public static boolean gameIsRunning = true;
    public static boolean xPlays = true;
	
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
   
        String[][] gs2d = {
        		{" ", " ", " "},
        		{" ", " ", " "},
        		{" ", " ", " "}
        };
        buildGame(gs2d);
        while (gameIsRunning) {
	        play(scanner, gs2d);
	        buildGame(gs2d);
	        result(gs2d);
        }
    }
    
    public static void buildGame(String[][] gs2d) {
        
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
        System.out.println();
        
        System.out.print("| ");
        for (int i = 0; i < gs2d.length; i++) {
            for (int j = 0; j < gs2d[i].length; j++) {
	            System.out.print(gs2d[i][j] + " ");
            }
            System.out.println("|");
            if (i != 2) {
                System.out.print("| ");
            }
        }
        
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
        
        gameIsRunning = false;
        for (String [] s : gs2d) {
        	for (String ss : s) {
        		if (ss.contentEquals(" ")) {
        			gameIsRunning = true;
        			return;
        		}
        	}
        }
        
    }
    
    public static void result(String[][] gs2d) {
        
        boolean oWon = false;
        boolean xWon = false;
        String x = "X";
        String o = "O";
        
        
        for (int i = 0; i < gs2d.length; i++) {
            if (Arrays.toString(gs2d[i]).contentEquals("[X, X, X]")) {
            	xWon = true;
            }
            if (Arrays.toString(gs2d[i]).contentEquals("[O, O, O]")) {
            	oWon = true;
            }
            if (gs2d[0][i].contentEquals(x) && gs2d[1][i].contentEquals(x) && gs2d[2][i].contentEquals(x)) {
            	xWon = true;
            }
            if (gs2d[0][i].contentEquals(o) && gs2d[1][i].contentEquals(o) && gs2d[2][i].contentEquals(o)) {
            	oWon = true;
            }
            
        }
        
        if (gs2d[0][0].contentEquals(x) && gs2d[1][1].contentEquals(x) && gs2d[2][2].contentEquals(x)) {
        	xWon = true;
        }
        if (gs2d[0][0].contentEquals(o) && gs2d[1][1].contentEquals(o) && gs2d[2][2].contentEquals(o)) {
        	oWon = true;
        }
        if (gs2d[0][2].contentEquals(x) && gs2d[1][1].contentEquals(x) && gs2d[2][0].contentEquals(x)) {
        	xWon = true;
        }
        if (gs2d[0][2].contentEquals(o) && gs2d[1][1].contentEquals(o) && gs2d[2][0].contentEquals(o)) {
        	oWon = true;
        }
        
        System.out.println();
        
        if (xWon) {
        	System.out.println(x + " wins");
        	gameIsRunning = false;
        	return;
        }
        if (oWon) {
        	System.out.println(o + " wins");
        	gameIsRunning = false;
        	return;
        }
        if (oWon == false && xWon == false && gameIsRunning == false) {
        	System.out.println("Draw");
        	return;
        }
        
    }
    
    public static void play(Scanner scanner, String[][] gs2d) {
    	
    	System.out.println();
    	String ab = "";
    	String a = "";
    	String b = "";
    	int c = 0;
    	int d = 0;
    	
    	while(true) {    
    	    System.out.println("Enter the coordinates:");
    	    ab = scanner.nextLine();
    	    a = ab.substring(0, 1);
    	    b = ab.substring(2);
    	    if (!(a.matches("\\d+") && b.matches("\\d+"))) {
    	    	System.out.println("You should enter numbers!");
    	    	continue;
    	    } else if (Integer.valueOf(a) > 3 || Integer.valueOf(a) < 1 ||
    	    		Integer.valueOf(b) > 3 || Integer.valueOf(b) < 1) {
    	    	System.out.println("Coordinates should be from 1 to 3!");
    	    	continue;
    	    } else {
    	    	c = Integer.valueOf(a) - 1;
    	    	d = Integer.valueOf(b) - 1;
    	    	if (!gs2d[c][d].contentEquals(" ")) {
    	    		System.out.println("This cell is occupied! Choose another one!");
    	    		continue;
    	    	}
    	    	gs2d[c][d] = xPlays ? "X" : "O";
    	    	xPlays = !xPlays;
    	    	return;
    	    }
    	}
    	
    }
}
import java.util.Scanner;

public class TicTacToe {
    private String[][] board = new String[3][3];

    public TicTacToe() {
        setupBoard();
        printBoard();
    }

    // Human v. Human Game
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        String cur = "X";
        while(!t.checkWin("O") && !t.checkWin("X") && !t.checkDraw()) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Player " + cur + " Make a move. Input X and Y");
            int x = scan.nextInt();
            int y = scan.nextInt();
            t.makeMove(--x, --y, cur);
            t.printBoard();
            cur = t.swapPlayer(cur);
        }

        if(t.checkWin("O")) {
            System.out.println("Player O wins!");
        } else if(t.checkWin("X")) {
            System.out.println("Player X wins!");
        } else {
            System.out.println("Draw!");
        }
    }

    public void setupBoard() {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                board[i][j] = " ";
            }
        }
    }

    public void printBoard() {
        System.out.println(this.toString());
    }

    public void makeMove(int x, int y, String player) {
        if(board[x][y] != " ") {
            System.out.println("Unble to make move, spot taken!");
            return;
        }
        board[x][y] = player;
    }

    public boolean checkWin(String player) {
        for(int i=0;i<board.length;i++) {
            String x = board[i][0] + board[i][1] + board[i][2];
            String y = player + player + player;
            if(x.equalsIgnoreCase(y)) return true;

            x = board[0][i] + board[1][i] + board[2][i];
            if(x.equalsIgnoreCase(y)) return true;
        }

        if((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
        (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    public boolean checkDraw() {
        if(checkWin("X") || checkWin("O")) return false;
        for(String[] row : board) {
            for(String val : row) {
                if(val.equalsIgnoreCase(" ")) return false;
            }
        }
        return true;
    }

    public String swapPlayer(String player) {
        if(player == "X") return "O";
        return "X";
    }

    @Override
    public String toString() {
        String out = "";
        out += "|-----|\n|";
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                out += board[i][j] + "|";
            }
            out += "\n|-----|\n|";
        }

        return out.substring(0, out.length()-2);
    }
}
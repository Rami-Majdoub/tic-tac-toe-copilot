// the tic-tac-toe game 
public class Game {
    
    // the board
    private char[][] board;
    
    // the current player
    private char currentPlayer;
    
    // the number of moves
    private int moves;
    
    // the number of wins for each player
    private int winsX;
    private int winsO;

    // the constructor
    public Game() {
        board = new char[3][3];
        currentPlayer = 'X';
        moves = 0;
        winsX = 0;
        winsO = 0;
    }

    // the getter for the board
    public char[][] getBoard() {
        return board;
    }

    // the getter for the current player
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // the getter for the number of moves
    public int getMoves() {
        return moves;
    }

    // the getter for the number of wins for each player
    public int getWinsX() {
        return winsX;
    }

    public int getWinsO() {
        return winsO;
    }  

    // the setter for the current player
    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    // the setter for the number of moves
    public void setMoves(int moves) {
        this.moves = moves;
    }

    // the setter for the number of wins for each player
    public void setWinsX(int winsX) {
        this.winsX = winsX;
    }

    public void setWinsO(int winsO) {
        this.winsO = winsO;
    }

    // the method to check if the game is over
    public boolean isGameOver() {
        return (moves == 9 || isWinner('X') || isWinner('O'));
    }

    // the method to check if the game is a tie
    public boolean isTie() {
        return (moves == 9 && !isWinner('X') && !isWinner('O'));
    }

    // the method to check if the game is won by a player
    public boolean isWinner(char player) {
        return (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||
               (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||
               (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||
               (board[0][0] == player && board[1][0] == player && board[2][0] == player) ||
               (board[0][1] == player && board[1][1] == player && board[2][1] == player) ||
               (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||
               (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    // the method to make a move
    public void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
        moves++;
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    // the method to print the board
    public void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // the method to print the game status
    public void printStatus() {
        System.out.println("Current player: " + currentPlayer);
        System.out.println("Number of moves: " + moves);
        System.out.println("Number of wins for X: " + winsX);
        System.out.println("Number of wins for O: " + winsO);
    }

    // the method to print the game result
    public void printResult() {
        if (isWinner('X')) {
            System.out.println("X wins!");
            winsX++;
        } else if (isWinner('O')) {
            System.out.println("O wins!");
            winsO++;
        } else if (isTie()) {
            System.out.println("Tie!");
        }
    }

    // the method to play the game
    public void play() {
        printBoard();
        printStatus();
        while (!isGameOver()) {
            System.out.print("Enter row and column: ");
            int row = Keyboard.readInt();
            int col = Keyboard.readInt();
            makeMove(row, col);
            printBoard();
            printStatus();
        }
        printResult();
    }

    // the main method
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
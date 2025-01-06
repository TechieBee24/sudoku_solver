//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int GRID_SIZE = 9;

    private static boolean isInrow(int[][] myBoard, int number, int row){
        for (int i=0;  i< GRID_SIZE; i++){
            if (myBoard[row][i] == number){
                return true;
            }
        }
        return false;
    }
    private static boolean isIncol(int[][] myBoard, int number, int col){
        for (int i=0;  i< GRID_SIZE; i++){
            if (myBoard[i][col] == number){
                return true;
            }
        }
        return false;
    }
    private static boolean isInbox(int[][] myBoard, int number,int row, int col){
        int smallBoxRow = row - row % 3;
        int smallBoxCol = col - col % 3;
        for (int i = smallBoxRow; i< smallBoxRow + 3; i++){
            for (int j = smallBoxCol; j<smallBoxCol + 3; j++){
                if (myBoard[i][j]== number){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] myBoard, int number, int row, int col){
        return !isInrow(myBoard,number,row) &&
                !isIncol(myBoard,number,col) &&
                !isInbox(myBoard,number,row,col) ;

    }

    private static boolean solve(int[][] board){
        for (int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                if (board[row][col] == 0){
                    for (int putNum = 1; putNum <= GRID_SIZE; putNum++){
                        if (isValid(board,putNum,row,col)){
                            board[row][col] = putNum;

                            if (solve(board)){
                                return true;
                            }else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard( int[][] board){
        for (int i=0; i< GRID_SIZE; i++){

        }
        for (int row=0; row< GRID_SIZE; row++){
            for (int col=0; col< GRID_SIZE; col++){
                System.out.print(board[row][col]);
            }
            System.out.println("\n-----------------------------------------");
        }

    }

    public static void main(String[] args) {

        int[][] myBoard = {
                {4,8,6,0,0,0,9,3,0},
                {7,3,0,0,4,9,0,0,0},
                {9,2,1,0,3,8,0,4,7},
                {3,0,9,0,8,0,5,1,6},
                {0,0,0,0,9,0,3,0,0},
                {0,1,8,0,0,5,4,7,0},
                {0,0,3,0,1,4,0,0,8},
                {0,9,2,8,0,3,0,6,4},
                {0,0,7,0,2,6,0,5,3}
        };
        if (solve(myBoard)){
            System.out.println("Board Solved");
        }else{
            System.out.println("Unsolvable board");
        }

        printBoard(myBoard);
    }

}
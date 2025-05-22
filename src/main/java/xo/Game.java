package xo;

class Game {

    int play(String square, boolean player) {
        // This will throw an exception if the player does not enter a number, but that is what I
        // would have done anyway.
        int index = Integer.parseInt(square) - 1;
        if (index < 0 || index > 8 || !Character.isDigit(board[index])) {
            throw new BoardSquareException("Not a valid square.");
        }
        board[index] = player ? 'X' : 'O';
        computer.freeSquares.remove(square.charAt(0));
        return index;
    }

    CharSequence getBoard() {
        StringBuilder boardPreview = new StringBuilder("\n");
        for (int row = 0; row < 3; row++) {
            boardPreview.append(board[row * 3]);
            boardPreview.append(" | ");
            boardPreview.append(board[row * 3 + 1]);
            boardPreview.append(" | ");
            boardPreview.append(board[row * 3 + 2]);
            boardPreview.append("\n");
        }
        return boardPreview;
    }

    public boolean checkWin(int index) {
        return index == 4 && hasThreeInADig(0)
            || index == 4 && hasThreeInADig(2)
            || index % 2 == 0 && hasThreeInADig(index)
            || hasThreeInACol(index % 3)
            || hasThreeInARow(index / 3);
    }

    private boolean hasThreeInARow(int row) {
        return board[row * 3] == board[row * 3 + 1] && board[row * 3 + 1] == board[row * 3 + 2];
    }

    private boolean hasThreeInACol(int col) {
        return board[col] == board[3 + col] && board[3 + col] == board[6 + col];
    }

    private boolean hasThreeInADig(int dig) {
        return board[dig] == board[4] && board[4] == board[8 - dig];
    }

    final Computer computer;
    private final Character[] board;

    Game() {
        board = new Character[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        computer = new Computer(board);
    }

}
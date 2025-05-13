package xo;

class Game {

    int play(String square, boolean player) {
        int index;
        // Unlike Bo Burnham, I think that I can handle this
        try {
            index = Integer.parseInt(square) - 1;
        } catch (NumberFormatException exception) {
            if (Math.random() < 0.05) computer.say("no.");
            // I don't think that I can handle this right now
            throw new PICNICException();
        }
        if (index < 0 || index > 8 || !Character.isDigit(board[index])) {
            // Sorry
            System.out.println("By order of the jarl, stop right there!");
            System.out.println("You have commited crimes against Skyrim and her people.");
            System.out.println("What say you in your defence?");
            throw new PICNICException();
        }
        // Single quotes are for CHARS? OH!
        board[index] = player ? 'X' : 'O';
        computer.freeSquares.remove(square.charAt(0));
        return index;
    }

    CharSequence getBoard() {
        StringBuilder boardPreview = new StringBuilder("\n");
        // I could do two for loops but the options I've looked at for that just aren't nice
        // Something something code nesting
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

    // It's like, the same
    public boolean checkWin(int index) {
        // I undented them to make things line up
        return index == 4 && hasThreeInADig(0)
            || index == 4 && hasThreeInADig(2)
            || index % 2 == 0 && hasThreeInADig(index)
            || hasThreeInACol(index % 3)
            || hasThreeInARow(index / 3);
    }

    // ‘Exapunks.’ *SICK GUITAR INTRO*
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
// It was a lie. I wasn't sorry

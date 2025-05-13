package XO;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Computer {

    String choose() {
        Random random = new Random();
        return freeSquares.toArray(new Character[0])[random.nextInt(freeSquares.size())].toString();
    }

    // Yay, I can remove warning suppression
    // Nevermind, the cops are back
    @SuppressWarnings("SameParameterValue")
    void say(String no) {
        System.out.println("Computer says " + no);
    }

    // And here we see the wild mutable set, made of an immutable set
    // I guess I kind of want to do something with this? Like make it derived from the board
    // hmmm
    Set<Character> freeSquares;

    Computer(Character[] board) {
        this.freeSquares = new HashSet<>(Set.of(board));
    }

}

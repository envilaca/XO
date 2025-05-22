package xo;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Computer {

    String choose() {
        Random random = new Random();
        return freeSquares.toArray(new Character[0])[random.nextInt(freeSquares.size())].toString();
    }

    Set<Character> freeSquares;

    Computer(Character[] board) {
        this.freeSquares = new HashSet<>(Set.of(board));
    }

}

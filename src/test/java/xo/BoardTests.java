package xo;

import org.junit.jupiter.api.*;

public class BoardTests {

    @BeforeEach
    void beforeEach() {
        game = new Game();
    }

    @Test
    void invalidMovesRejected() {
        // Arrange

        // Act
        game.play("1", true);

        // Assert
        Assertions.assertThrows(PICNICException.class, () -> game.play("1", true));
    }

    @Test
    void horizontalWinWins() {
        // Arrange

        // Act
        game.play("4", true);
        game.play("5", true);
        game.play("6", true);

        // Assert
        Assertions.assertTrue(game.checkWin(3));
    }

    @Test
    void verticalWinWins() {
        // Arrange

        // Act
        game.play("2", true);
        game.play("5", true);
        game.play("8", true);

        // Assert
        Assertions.assertTrue(game.checkWin(7));
    }

    @Test
    void diagonalWinWins() {
        // Arrange

        // Act
        game.play("3", true);
        game.play("5", true);
        game.play("7", true);

        // Assert
        Assertions.assertTrue(game.checkWin(2));
    }

    @AfterEach
    void afterEach() {

    }

    Game game;
}

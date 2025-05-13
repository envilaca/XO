package XO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTests {

    @Test
    void invalidMovesRejected() {
        // Arrange
        Game game = new Game();

        // Act
        game.play("1", true);

        // Assert
        Assertions.assertThrows(PICNICException.class, () -> game.play("1", true));
    }

}

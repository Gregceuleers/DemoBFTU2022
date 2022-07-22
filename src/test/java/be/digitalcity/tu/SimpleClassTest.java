package be.digitalcity.tu;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleClassTest {

    @Test
    @DisplayName("TOTO fait des tests")
    void premierTestCalculSucces() {
        // ARRANGE
        int a = 3, b = 4;
        int result;

        // ACT
        result = new Calculation().addition(a,b);

        //ASSERT
        assertEquals(7, result);
    }

    @Test
    @DisplayName("ZOTO fait des tests")
    void premierTestCalculFailed() {
        // ARRANGE
        int a = 3, b = 4;
        int result;

        // ACT
        result = a + b;

        //ASSERT
        assertNotEquals(8, result);
    }

    @Test
    void divisionParZeroDoitRetournerUneException() {
        // Arrange
        int dividende = 5, diviseur = 0;


        // Act

        // Assert
      ArithmeticException exception =  assertThrows(ArithmeticException.class, () -> {
            int result = dividende / diviseur;
        } );

      assertEquals("division par zéro", exception.getMessage());
    }

}

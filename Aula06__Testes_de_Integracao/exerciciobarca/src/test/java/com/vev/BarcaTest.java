package com.vev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.provider.CsvSource;


public class BarcaTest {

    @CsvSource({"F02A12", "F45A01", "F33A18"})
    public void ocupaLugarBasic(String assento) {
        // Arrange
        Barca barca = new Barca();
        int resultado = barca.ocupaLugar("F02A12");

        // Act
        final int ESPERADO = 3;

        // Assert
        assertEquals(ESPERADO, resultado);
    }

    
}

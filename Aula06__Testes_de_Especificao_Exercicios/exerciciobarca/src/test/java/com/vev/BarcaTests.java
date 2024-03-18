package com.vev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BarcaTests {
    /**
     * Regras de resposta de ocupação de assentos:
     * 
     * 0 – Identificador de assento inválido
     * 1 – Assento ocupado
     * 2 – Assento bloqueado devido a distribuição de peso
     * 3 – Ok, assento atribuído ao passageiro.
     */
    private Barca barca;

    @BeforeEach
    public void setUp() {
        barca = new Barca();
    }

    @Test
    public void occupiesFreeSeat() {
        int result = barca.ocupaLugar("F02A12");
        final int EXPECTED = 3;
        assertEquals(EXPECTED, result);
    }

    @Test
    public void doesNotOccupyDueToWeightDistribution() {
        int result = barca.ocupaLugar("F33A18");
        final int EXPECTED = 2;
        assertEquals(EXPECTED, result);
    }

    @Test
    public void doesNotOccupyOccupiedSeat() {
        barca.ocupaLugar(45, 1);
        int result = barca.ocupaLugar("F45A01");
        final int EXPECTED = 1;
        assertEquals(EXPECTED, result);
    }

    @Test
    public void doesNotOccupyInvalidSeat() {
        int result = barca.ocupaLugar("F00A0");
        final int EXPECTED = 0;
        assertEquals(EXPECTED, result);
    }
}

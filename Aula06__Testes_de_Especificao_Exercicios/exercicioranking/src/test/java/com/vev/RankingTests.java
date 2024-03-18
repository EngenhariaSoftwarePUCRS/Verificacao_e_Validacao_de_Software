package com.vev;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RankingTests {
    // Partições:
    // P1: Menos de 10 jogadores
    // P2: Pelo menos 10 jogadores
    // S1: Score maior que o pior score
    // S2: Score menor que o pior score
    private static Ranking ranking = null;

    @BeforeAll
    static void setup() {
        // Adiciona 9 jogadores ao ranking
        ranking = new Ranking();
        for (int i = 9; i > 0; i--) {
            int playerId = 10 - i;
            int playerScore = i * 100 + 99;
            Record playerRecord = new Record("Player " + playerId, playerScore);
            ranking.add(playerRecord);
        }
        System.out.println("Ranking inicial:");
        for (int i = 0; i < ranking.numRecords(); i++) {
            String player = ranking.getScore(i).getName();
            int score = ranking.getScore(i).getScore();
            System.out.println(player + " - " + score);
        }
    }

    private void addPlaceholderRanking() {
        ranking.add(new Record("SYSTEM", 999999999));
    }

    @Test
    public void testAddToNonFullRanking() {
        Record record = new Record("Player 10", 1);
        boolean added = ranking.add(record);
        assertTrue(added);
    }

    @Test
    public void testAddToFullRankingWithBetterScore() {
        addPlaceholderRanking();
        Record record = new Record("Player 11", 1000);
        boolean added = ranking.add(record);
        assertTrue(added);
    }

    @Test
    public void testAddToFullRankingWithWorseScore() {
        addPlaceholderRanking();
        Record record = new Record("Player 12", 100);
        boolean added = ranking.add(record);
        assertFalse(added);
    }
}

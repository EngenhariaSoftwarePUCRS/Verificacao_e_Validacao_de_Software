package com.vev.exemplo;

public class NewShepard {
    static final float MIN_WEIGHT = 50;
    static final float MAX_WEIGHT = 101;
    static final float MIN_HEIGHT = 1.52f;
    static final float MAX_HEIGHT = 1.95f;
    static final float MIN_TIME = 0;
    static final float MAX_TIME = 80;

    public static boolean autoriza(float peso, float altura, float tempoEscadas) {
        if (peso < MIN_WEIGHT || peso > MAX_WEIGHT) {
            return false;
        }

        if (altura < MIN_HEIGHT || altura > MAX_HEIGHT) {
            return false;
        }

        if (tempoEscadas < MIN_TIME || tempoEscadas > MAX_TIME) {
            return false;
        }

        return true;
    }
}

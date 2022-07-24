package br.com.vnrg.hexagonalarchitecture.order.util;

import java.util.UUID;

public final class GeneratorID {
    private GeneratorID() {
    }

    public static String stringUUID() {
        return UUID().toString();
    }

    public static UUID UUID() {
        return UUID.randomUUID();
    }
}

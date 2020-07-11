package pl.sda.medicalcrm.util;

import java.util.Objects;

public class Preconditions {
    public static void requireNonNulls(Object ...args) {
        for (Object arg : args) {
            Objects.requireNonNull(arg);
        }
    }
}

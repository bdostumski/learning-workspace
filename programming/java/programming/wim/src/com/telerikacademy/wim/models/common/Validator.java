package com.telerikacademy.wim.models.common;

import java.util.List;

public class Validator {

    public static void validateIntRange(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateIntLessThanZero(int value, String message) {
        if(value < 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateArgumentIsNotNull(Object arg, String message) {
        if (arg == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <E> void checkListNotContainsValue(List<E> list, E value, String message) {
        if(!list.contains(value)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <E> void checkForExistingValue(List<E> list, E value, String message) {
        if(list.contains(value)) {
            throw new IllegalArgumentException(message);
        }
    }
}

package com.example.tes20april;

public class LocalStorage {
    private static String id;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        LocalStorage.id = id;
    }
}

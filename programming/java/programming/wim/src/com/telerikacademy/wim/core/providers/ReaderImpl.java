package com.telerikacademy.wim.core.providers;

import com.telerikacademy.wim.core.contracts.Reader;

import java.util.Scanner;

public class ReaderImpl implements Reader {

    private final Scanner scanner;

    public ReaderImpl() {
        scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }

}

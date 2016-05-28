package me.arkadiy.gumenniy.view;

import java.util.Scanner;

/**
 * Created by Arkadiy on 28.05.2016.
 */
public class Console implements View {
    private final Scanner in = new Scanner(System.in);

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public String read(String ask) {
        System.out.print(ask);
        return in.nextLine();
    }
}

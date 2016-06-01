package me.arkadiy.gumenniy;

import me.arkadiy.gumenniy.controller.BaseController;
import me.arkadiy.gumenniy.controller.PresentController;
import me.arkadiy.gumenniy.model.PresentModel;
import me.arkadiy.gumenniy.view.Console;

public class Main {

    public static void main(String[] args) {
        BaseController controller = new PresentController(new Console(), new PresentModel());
        controller.start();
    }
}

package me.arkadiy.gumenniy;

import me.arkadiy.gumenniy.model.PresentModel;
import me.arkadiy.gumenniy.model.entity.Present;
import me.arkadiy.gumenniy.model.entity.PresentItem;
import me.arkadiy.gumenniy.model.entity.SweetType;
import me.arkadiy.gumenniy.view.Console;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(new PresentModel().fetchData());
        Present present = new Present();
//
//        present.addPresentItem(new PresentItem("Взлётная", SweetType.CARAMEL, 1.5f, 5, 50));
//        present.addPresentItem(new PresentItem("Дюшеска", SweetType.CARAMEL, 1.5f, 4, 50));
//        present.addPresentItem(new PresentItem("Барбариска", SweetType.CARAMEL, 1.5f, 4, 60));
//        present.addPresentItem(new PresentItem("Овсяное", SweetType.COOKIE, 20f, 3, 30));
//        present.addPresentItem(new PresentItem("День-Ночь", SweetType.COOKIE, 15f, 5, 45));
//        present.addPresentItem(new PresentItem("Мария", SweetType.COOKIE, 5f, 3, 20));
//        present.addPresentItem(new PresentItem("Белиссимо", SweetType.CHOCOLATE, 5f, 7, 60));
//        present.addPresentItem(new PresentItem("Candy Nut", SweetType.CHOCOLATE, 3f, 10, 45));
//        present.addPresentItem(new PresentItem("Нуга", SweetType.CHOCOLATE, 2.5f, 8, 55));

        BaseController controller = new PresentController(new Console(), present);
        controller.start();
    }
}

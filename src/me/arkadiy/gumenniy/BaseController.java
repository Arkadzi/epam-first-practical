package me.arkadiy.gumenniy;

import me.arkadiy.gumenniy.view.View;

/**
 * Created by Arkadiy on 28.05.2016.
 */
public abstract class BaseController {
    private View view;

    public BaseController(View view) {
        this.view = view;
    }

    public abstract void start();

    public View getView() {
        return view;
    }
}

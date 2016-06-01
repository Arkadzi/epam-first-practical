package me.arkadiy.gumenniy.controller;

import me.arkadiy.gumenniy.model.Model;
import me.arkadiy.gumenniy.view.View;

/**
 * Simple base controller with ability to read user input and to display some string data
 */
public abstract class BaseController<T> {
    /**
     * interface with user
     */
    private View view;
    /**
     * model to communicate with
     */
    private final Model<T> model;

    public BaseController(View view, Model<T> model) {
        this.view = view;
        this.model = model;
    }

    /**
     * method to begin action
     */
    public abstract void start();

    public View getView() {
        return view;
    }

    public Model<T> getModel() {
        return model;
    }
}

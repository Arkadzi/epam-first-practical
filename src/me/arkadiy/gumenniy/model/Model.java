package me.arkadiy.gumenniy.model;

import java.util.List;

/**
 * Created by Arkadiy on 28.05.2016.
 */
public interface Model<T> {
    List<T> fetchData();
}

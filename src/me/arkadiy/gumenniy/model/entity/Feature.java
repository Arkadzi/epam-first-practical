package me.arkadiy.gumenniy.model.entity;

/**
 * Created by Arkadiy on 28.05.2016.
 */
public interface Feature<T> {
    boolean fits(T object);
}

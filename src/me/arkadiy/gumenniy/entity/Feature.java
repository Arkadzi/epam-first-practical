package me.arkadiy.gumenniy.entity;

/**
 * Created by Arkadiy on 28.05.2016.
 */
public interface Feature<T> {
    boolean fits(T object);
}

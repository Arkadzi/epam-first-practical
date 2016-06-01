package me.arkadiy.gumenniy.model;

import java.util.List;

/**
 * Simpe model with ability to fetch data
 */
public interface Model<T> {
    /**
     * fetches data
     *
     * @return - fetched data
     */
    List<T> fetchData();
}

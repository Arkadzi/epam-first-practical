package me.arkadiy.gumenniy.util;

/**
 * defines some rules to determine whether some object has appropriate features
 */
public interface Feature<T> {
    /**
     * verifies some object
     *
     * @param object - verifiable object
     * @return @true if object fits some defined rules, @false - otherwise
     */
    boolean fits(T object);
}

package me.arkadiy.gumenniy.model.entity;


import me.arkadiy.gumenniy.util.Feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * container for present items
 *
 * @see Sweet
 */
public class Present {
    /**
     * list of present items
     */
    private final List<Sweet> items;
    /**
     * total weight of present
     */
    private float weight;
    /**
     * total price of present
     */
    private float price;

    public Present() {
        items = new ArrayList<>();
    }

    /**
     * adds present item into present
     *
     * @param item - adding item
     */
    public void addPresentItem(Sweet item) {
        item = new Sweet(item);
        items.add(item);
        weight += item.getWeight();
        price += item.getPrice();
    }

    /**
     * finds present items by some feature
     *
     * @param feature - rules to search
     * @return - list of fit present items
     */
    public List<Sweet> findPresentItemByFeature(Feature<Sweet> feature) {
        List<Sweet> result = new ArrayList<>();

        for (Sweet item : items) {
            if (feature.fits(item)) {
                result.add(new Sweet(item));
            }
        }

        return result;
    }

    /**
     * removes present items by some feature
     *
     * @param feature - rule to remove
     * @return - list of removed items
     */
    public List<Sweet> removeByFeature(Feature<Sweet> feature) {
        List<Sweet> result = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            Sweet item = items.get(i);
            if (feature.fits(item)) {
                result.add(items.remove(i));
                price -= item.getPrice();
                weight -= item.getWeight();
            }
        }

        return result;
    }

    /**
     * sorts by some rule
     *
     * @param comparator - rule to sort
     */
    public void sortByFeature(Comparator<Sweet> comparator) {
        Collections.sort(items, comparator);
    }

    public float getWeight() {
        return weight;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Present{" +
                "weight=" + weight +
                ", price=" + price +
                ", items=" + items +
                '}';
    }
}

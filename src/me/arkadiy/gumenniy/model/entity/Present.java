package me.arkadiy.gumenniy.model.entity;


import java.util.*;

/**
 * Created by Arkadiy on 28.05.2016.
 */
public class Present {
    private final List<PresentItem> items;
    private float weight;
    private float price;

    public Present() {
        items = new ArrayList<>();
    }

    public void addPresentItem(PresentItem item) {
        item = new PresentItem(item);
        items.add(item);
        weight += item.getWeight();
        price += item.getPrice();
    }

    public List<PresentItem> findPresentItemByFeature(Feature<PresentItem> feature) {
        List<PresentItem> result = new ArrayList<>();

        for (PresentItem item : items) {
            if (feature.fits(item)) {
                result.add(new PresentItem(item));
            }
        }

        return result;
    }

    public List<PresentItem> removeByFeature(Feature<PresentItem> feature) {
        List<PresentItem> result = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            PresentItem item = items.get(i);
            if (feature.fits(item)) {
                result.add(items.remove(i));
                price -= item.getPrice();
                weight -= item.getWeight();
            }
        }

        return result;
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

    public void sortByFeature(Comparator<PresentItem> comparator) {
        Collections.sort(items, comparator);
    }
}

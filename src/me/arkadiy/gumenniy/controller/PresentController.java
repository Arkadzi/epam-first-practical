package me.arkadiy.gumenniy.controller;

import me.arkadiy.gumenniy.model.Model;
import me.arkadiy.gumenniy.model.entity.Present;
import me.arkadiy.gumenniy.model.entity.Sweet;
import me.arkadiy.gumenniy.view.View;

import java.util.Comparator;
import java.util.List;

/**
 * Simple controller for manipulations with Present Model
 */
public class PresentController extends BaseController<Sweet> {

    public PresentController(View view, Model<Sweet> presentModel) {
        super(view, presentModel);
    }

    public void start() {
        Present present = new Present();
        getModel().fetchData().forEach(present::addPresentItem);
        getView().display(present.toString());
        findSweets(present);
        sort("Let's sort by sugar proportion.", present, (o1, o2) -> o1.getSugarProportion() - o2.getSugarProportion());
        sort("Let's sort by weight.", present, (o1, o2) -> o1.getWeight() - o2.getWeight() >= 0 ? 1 : -1);
    }

    /**
     * finds and displays some sweets by sugar proportion criteria
     *
     * @param present - supposed data container
     */
    private void findSweets(Present present) {
        getView().display("Let's find some sweets.");
        getView().display("Please, input sugar proportion boundaries.");
        float from = readFloat("from:");
        float to = readFloat("to:");

        List<Sweet> itemByFeature = present.findPresentItemByFeature(
                item -> item.getSugarProportion() >= from && item.getSugarProportion() <= to
        );

        getView().display(String.format("found: %s", itemByFeature.toString()));
    }

    /**
     * sorts data in present by some criteria
     *
     * @param message               - message to display to user
     * @param present               - container of sorting data
     * @param presentItemComparator - criteria to sort
     */
    private void sort(String message, Present present, Comparator<Sweet> presentItemComparator) {
        getView().display(message);
        present.sortByFeature(presentItemComparator);
        getView().display(present.toString());
    }

    /**
     * util method to read float numbers
     *
     * @param ask - inviting message to user
     * @return - valid float value
     */
    private float readFloat(String ask) {
        try {
            float result = Float.parseFloat(getView().read(ask));
            if (result < 0 || result > 100) throw new IllegalArgumentException();
            return result;
        } catch (IllegalArgumentException e) {
            return readFloat(ask);
        }
    }
}

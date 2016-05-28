package me.arkadiy.gumenniy;

import me.arkadiy.gumenniy.entity.Present;
import me.arkadiy.gumenniy.entity.PresentItem;
import me.arkadiy.gumenniy.view.View;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Arkadiy on 28.05.2016.
 */
public class PresentController extends BaseController {

    private final Present present;

    public PresentController(View view, Present present) {
        super(view);
        this.present = present;
    }

    public void start() {
        getView().display(present.toString());

        findSweets();
        sort("let's sort by sugar proportion", (o1, o2) -> o1.getSugarProportion() - o2.getSugarProportion());
        sort("let's sort by weight", (o1, o2) -> o1.getWeight() - o2.getWeight() >= 0 ? 1 : -1);
    }

    private void findSweets() {
        getView().display("Let's find some sweets.");
        getView().display("Please, input sugar proportion boundaries.");
        float from = readFloat("from:");
        float to = readFloat("to:");

        List<PresentItem> itemByFeature = present.findPresentItemByFeature(
                item -> item.getSugarProportion() >= from && item.getSugarProportion() <= to
        );
        getView().display(String.format("found: %s", itemByFeature.toString()));
    }

    private void sort(String message, Comparator<PresentItem> presentItemComparator) {
        getView().display(message);
        present.sortByFeature(presentItemComparator);
        getView().display(present.toString());
    }

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

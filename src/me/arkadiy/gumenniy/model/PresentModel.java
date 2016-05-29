package me.arkadiy.gumenniy.model;

import me.arkadiy.gumenniy.model.entity.PresentItem;
import me.arkadiy.gumenniy.model.entity.SweetType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Arkadiy on 28.05.2016.
 */
public class PresentModel implements Model<PresentItem> {

    @Override
    public List<PresentItem> fetchData() {
        List<PresentItem> items = new ArrayList<>();

        Path path = Paths.get("db.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> {
                try {
                    String[] data = s.split("/");
                    String name = data[0];
                    SweetType sweetType = SweetType.valueOf(data[1]);
                    float weight = Float.parseFloat(data[2]);
                    float price = Float.parseFloat(data[3]);
                    int sugarProportion = Integer.parseInt(data[4]);
                    items.add(new PresentItem(name, sweetType, weight, price, sugarProportion));
                } catch (IllegalArgumentException e) {}
            });
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return  items;
    }
}

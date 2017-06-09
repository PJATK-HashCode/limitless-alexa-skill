package limitless;

import java.util.List;

/**
 * @author Lelental on 09.06.2017.
 */
public class DataObject {
    private String body;
    private List<Item> item;

    DataObject(String body, List<Item> item) {
        this.body = body;
        this.item = item;
    }

    @Override
    public String toString() {
        return body + item;
    }
}

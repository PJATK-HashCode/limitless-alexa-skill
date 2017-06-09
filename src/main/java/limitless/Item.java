package limitless;

/**
 * @author Lelental on 09.06.2017.
 */
public class Item {

    private String body;

    public Item(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }
}

package limitless;

import java.util.List;

/**
 * @author Lelental on 09.06.2017.
 */
public class DataObject {

    private String disabilityInformation;
    private String cartName;
    private boolean guideDog;
    private boolean wheelChair;
    private boolean foldingWheelchair;
    private boolean nonFoldingWheelChair;
    private boolean guideDogTravelWithYou;
    private List<Item> item;

    public DataObject(String disabilityInformation, boolean guideDog, boolean wheelChair, boolean foldingWheelchair,
                      boolean nonFoldingWheelChair, boolean guideDogTravelWithYou, List<Item> item, String cartName) {
        this.disabilityInformation = disabilityInformation;
        this.guideDog = guideDog;
        this.wheelChair = wheelChair;
        this.foldingWheelchair = foldingWheelchair;
        this.nonFoldingWheelChair = nonFoldingWheelChair;
        this.guideDogTravelWithYou = guideDogTravelWithYou;
        this.cartName = cartName;
        this.item = item;
    }

    @Override
    public String toString() {

        return "Your disability information for cart'" + cartName + "that you've given:" + disabilityInformation
                + '\'' + "and chosen options for this card:" +
                ", guideDog=" + guideDog +
                ", wheelChair=" + wheelChair +
                ", foldingWheelchair=" + foldingWheelchair +
                ", nonFoldingWheelChair=" + nonFoldingWheelChair +
                ", guideDogTravelWithYou=" + guideDogTravelWithYou +
                ", item=" + item +
                '}';
    }
}

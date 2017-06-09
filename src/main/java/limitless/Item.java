package limitless;

/**
 * @author Lelental on 09.06.2017.
 */
public class Item {

    private String disabilityInformation;
    private boolean guideDog;
    private boolean wheelChair;
    private boolean foldingWheelchair;
    private boolean nonFoldingWheelChair;
    private boolean guideDogTravelWithYou;


    public Item(String disabilityInformation, boolean guideDog, boolean wheelChair, boolean foldingWheelchair,
                boolean nonFoldingWheelChair, boolean guideDogTravelWithYou) {
        this.disabilityInformation = disabilityInformation;
        this.guideDog = guideDog;
        this.wheelChair = wheelChair;
        this.foldingWheelchair = foldingWheelchair;
        this.nonFoldingWheelChair = nonFoldingWheelChair;
        this.guideDogTravelWithYou = guideDogTravelWithYou;
    }

    @Override
    public String toString() {
        return "Item{" +
                "disabilityInformation='" + disabilityInformation + '\'' +
                ", guideDog=" + guideDog +
                ", wheelChair=" + wheelChair +
                ", foldingWheelchair=" + foldingWheelchair +
                ", nonFoldingWheelChair=" + nonFoldingWheelChair +
                ", guideDogTravelWithYou=" + guideDogTravelWithYou +
                '}';
    }
}

package limitless;


/**
 * @author Lelental on 09.06.2017.
 */
public class DataObject {

    private String disabilityInformation;
    private String cartName;
    private String medicinesInformation;
    private boolean guideDog;
    private boolean guideDogTravelWithYou;
    private boolean guideIsNeeded;
    private String guideDogText;
    private String guideIsNeededText;
    private String noneText;

    public DataObject(String disabilityInformation, String cartName, String medicinesInformation, boolean guideDog,
                      boolean guideDogTravelWithYou, boolean guideIsNeeded) {
        this.disabilityInformation = disabilityInformation;
        this.cartName = cartName;
        this.medicinesInformation = medicinesInformation;
        this.guideDog = guideDog;
        this.guideDogTravelWithYou = guideDogTravelWithYou;
        this.guideIsNeeded = guideIsNeeded;
        setTexts();
    }

    @Override
    public String toString() {

        return "Your disability information for cart '" + cartName + " that you've given is: " + disabilityInformation
                + '\'' + "your send medical information is: " + medicinesInformation
                + " and chosen options for this card: "
                + noneText
                + guideDogText
                + guideIsNeededText
                + '}';
    }

    private void setTexts() {
        
        if (guideDog && guideDogTravelWithYou) {
            guideDogText = "dog assistant will be travel with you";
        } else {
            guideDogText = "";
        }
        if (guideIsNeeded) {
            guideIsNeededText = "and guide assistant in Airport is needed ";
        } else {
            guideIsNeededText = "";
        }

        if (!guideDog && !guideDogTravelWithYou && !guideIsNeeded) {
            String noneText = "none";
        } else {
            noneText = "";
        }
    }
}

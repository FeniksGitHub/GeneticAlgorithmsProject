import java.util.Random;

public class BinaryIndividual implements IIindividual {
    private String x;
    private String y;
    public BinaryIndividual(String x, String y) {
        this.x = x;
        this.y = y;
    }
    public String getX() {
        return x;
    }
    public String getY() {
        return y;
    }
    public void mutate() {
        Random random = new Random();
        // Mutacja x
        StringBuilder newX = new StringBuilder(x);
        int indexX = random.nextInt(x.length());
        char bitX = x.charAt(indexX);
        char mutatedBitX = (bitX == '0') ? '1' : '0';
        newX.setCharAt(indexX, mutatedBitX);
        x = newX.toString();
        // Mutacja y
        StringBuilder newY = new StringBuilder(y);
        int indexY = random.nextInt(y.length());
        char bitY = y.charAt(indexY);
        char mutatedBitY = (bitY == '0') ? '1' : '0';
        newY.setCharAt(indexY, mutatedBitY);
        y = newY.toString();
    }
    public IIindividual crossover(IIindividual partner) {
        String partnerX = ((BinaryIndividual) partner).getX();
        String partnerY = ((BinaryIndividual) partner).getY();
        // Krzyżowanie x
        int midIndexX = x.length() / 2;
        String childX = x.substring(0, midIndexX) + partnerX.substring(midIndexX);
        // Krzyżowanie y
        int midIndexY = y.length() / 2;
        String childY = y.substring(0, midIndexY) + partnerY.substring(midIndexY);
        return new BinaryIndividual(childX, childY);
    }
    public double fitness() {
        int decimalX = Integer.parseInt(x, 2);
        int decimalY = Integer.parseInt(y, 2);
        return (-Math.pow(475 - decimalX, 2) - Math.pow(500 - decimalY, 2) + 600000);
    }
    @Override
    public String toString() {
        return "(" + Integer.parseInt(x, 2) + ", " + Integer.parseInt(y, 2) + ")";
    }
}
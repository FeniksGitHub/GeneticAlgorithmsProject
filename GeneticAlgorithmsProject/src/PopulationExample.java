public class PopulationExample {
    public static void run() {
        CAG cag = new CAG();
        IIindividual bestIndividual = cag.solve();
        BinaryIndividual bestBinaryIndividual = (BinaryIndividual) bestIndividual;
        int decimalX = Integer.parseInt(bestBinaryIndividual.getX(), 2);
        int decimalY = Integer.parseInt(bestBinaryIndividual.getY(), 2);
        System.out.println("Najlepsze znalezione miejsce: (" + decimalX + ", " + decimalY + ")");
        System.out.println("Poziom zaludnienia: " + bestIndividual.fitness());
    }

}

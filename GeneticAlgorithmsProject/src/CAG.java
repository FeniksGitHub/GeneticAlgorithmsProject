
import java.util.*;

public class CAG {
    private static final int POPULATION_SIZE = 200;
    private static final double MUTATION_RATE = 0.01;
    private static final int MAX_GENERATIONS = 100;

    private List<IIindividual> population;

    public CAG() {
        population = new ArrayList<>();
    }

    public IIindividual solve() {
        initializePopulation();

        System.out.println("Initial Population:");
        for (IIindividual individual : population) {
            System.out.println(individual.toString());
        }
        System.out.println();

        for (int generation = 0; generation < MAX_GENERATIONS; generation++) {
            List<IIindividual> newPopulation = new ArrayList<>();

            while (newPopulation.size() < POPULATION_SIZE) {
                IIindividual parent1 = selection();
                IIindividual parent2 = selection();
                IIindividual child = parent1.crossover(parent2);

                if (Math.random() < MUTATION_RATE) {
                    child.mutate();
                }

                newPopulation.add(child);
            }

            population = newPopulation;
        }

        return getBestIndividual();
    }

    private void initializePopulation() {
        Random random = new Random();

        for (int i = 0; i < POPULATION_SIZE; i++) {
            String x = generateRandomBinaryString(10);
            String y = generateRandomBinaryString(10);
            population.add(new BinaryIndividual(x, y));
        }
    }

    private String generateRandomBinaryString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(2));
        }

        return sb.toString();
    }

    private IIindividual selection() {
        Collections.shuffle(population);
        int tournamentSize = POPULATION_SIZE / 10;
        List<IIindividual> tournament = population.subList(0, tournamentSize);
        return Collections.max(tournament, Comparator.comparingDouble(IIindividual::fitness));
    }

    private IIindividual getBestIndividual() {
        return Collections.max(population, Comparator.comparingDouble(IIindividual::fitness));
    }
}

public interface IIindividual {
    void mutate();
    IIindividual crossover(IIindividual partner);
    double fitness();
    String toString();
}
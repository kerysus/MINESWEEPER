/**
 * Táto trieda spúšťa samotnú hru.
 */
public class Hra {
    private UserInput userInput;
    /**
     * Táto metóda tvorí konštruktor triedy, v ktorej volá len jednu metódu na spustenie hry.
     */
    public Hra() {
        this.userInput = new UserInput();
    }
}

import java.util.Scanner;

/**
 * Táto trieda berie vstupy od uživatela do hry.
 */
public class UserInput {
    private Plocha plocha;
    private Napoveda napoveda;
    private Scanner scanner;
    
    /**
     * Táto metóda tvorí konštruktor triedy.
     */
    public UserInput() {
        this.scanner = new Scanner(System.in);
        this.vytvorHru();
        this.makeGuesses();
    }
    
    /**
     * Táto metóda pýta od uživateľa stupeň obtiažnosti hry.
     */
    public void vytvorHru() {
        System.out.println("Zadaj obtiažnosť hry: 1)ľahká  2)pokročilá 3) ťažká");
        int obtiaznost = this.scanner.nextInt();
        switch (obtiaznost) {
            case 1:
                this.vytvorPlochu(5);
                this.vytvorPoleMin(1);
                break;
            case 2:
                this.vytvorPlochu(8);
                this.vytvorPoleMin(5);
                break;
            case 3:
                this.vytvorPlochu(10);
                this.vytvorPoleMin(20);
                break;
            default:
                System.out.println("Chybný input, skús ešte raz");
                this.vytvorHru();
        }
    }
    
    /**
     * Táto metóda vytvorí nový objekt triedy Plocha.
     */
    public void vytvorPlochu(int riadky) {
        this.plocha = new Plocha(riadky, riadky);
    }

    /**
     * Táto metóda volá metódu vytvorPoleBomb z triedy Plocha a vytvorí daný počet mín v hre.
     */
    public void vytvorPoleMin(int pocetMin) {
        this.plocha.vytvorPoleBomb(pocetMin);
    }

    /**
     * Táto metóda pýta od uživatela či chce spraviť ohad na odkrytie políčka, položiť vlajku na políčko, zdvihnuť vlajku alebo zobraziť nápovedu.
     */
    public void makeGuesses() {
        if (!this.plocha.getVyhra() && !this.plocha.getPrehra()) {
            System.out.println("Vyber: odhad(1), polož vlajku(2), zdvihni vlajku(3), daj nápovedu(4): ");
            int vyber = this.scanner.nextInt();

            switch (vyber) {
                case 1:
                    System.out.println("Zadaj X: ");
                    int suradnicaX = this.scanner.nextInt();
                    System.out.println("Zadaj Y: ");
                    int suradnicaY = this.scanner.nextInt();
                    this.plocha.makeGuess(suradnicaY, suradnicaX);
                    break;
                case 2:
                    System.out.println("Zadaj X: ");
                    suradnicaX = this.scanner.nextInt();
                    System.out.println("Zadaj Y: ");
                    suradnicaY = this.scanner.nextInt();
                    this.plocha.polozVlajku(suradnicaY, suradnicaX);
                    break;
                case 3:
                    System.out.println("Zadaj X: ");
                    suradnicaX = this.scanner.nextInt();
                    System.out.println("Zadaj Y: ");
                    suradnicaY = this.scanner.nextInt();
                    this.plocha.zdvihniVlajku(suradnicaX, suradnicaY);
                    break;
                case 4:
                    this.napoveda = new Napoveda();
                    break;
                default:
                    System.out.println("Chybný input, skús ešte raz");
            }
            this.makeGuesses();
        }
    }
}

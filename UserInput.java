import java.util.Scanner;

public class UserInput {
    private Plocha plocha;
    private Napoveda napoveda;
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
        this.vytvorHru();
        this.makeGuesses();
        this.napoveda = new Napoveda();
    }

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

    public void vytvorPlochu(int riadky) {
        this.plocha = new Plocha(riadky, riadky);
    }

    public void vytvorPoleMin(int pocetMin) {
        this.plocha.vytvorPoleBomb(pocetMin);
    }

    public void makeGuesses() {
        if (!this.plocha.getVyhra() && !this.plocha.getPrehra()) {
            System.out.println("Vyber: odhad(1), polož vlajku(2), zdvihni vlajku(3), zobraz nápovedu(4): ");
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
                    this.napoveda.dajNapovedu();
                    break;
                default:
                    System.out.println("Chybný input, skús ešte raz");
            }
            this.makeGuesses();
        }
    }
}

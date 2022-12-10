import java.util.Scanner;

public class userInput {
    private Plocha plocha;
    private Scanner scanner;
    
    public userInput() {
        this.scanner = new Scanner(System.in);
        this.vytvorHru();
        this.makeGuesses();
    }
    
    public void vytvorHru(){
        System.out.println("Zadaj obťiažnosť hry: 1)ľahká  2)pokročilá 3) ťažká");
        int obtiaznost = scanner.nextInt();
        switch(obtiaznost){
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

    public void vytvorPlochu(int riadky){
        this.plocha = new Plocha(riadky, riadky);
    }
    
    public void vytvorPoleMin(int pocetMin){
        this.plocha.vytvorPoleBomb(pocetMin);
    }
    
    public void makeGuesses(){
        if(!this.plocha.getVyhra() && !this.plocha.getPrehra()){
            System.out.println("Vyber: odhad(1), polož vlajku(2), zdvihni vlajku(3): ");
            int vyber = scanner.nextInt();
            
            switch(vyber){
                case 1:
                    System.out.println("Zadaj X: ");
                    int suradnicaX = scanner.nextInt();
                    System.out.println("Zadaj Y: ");
                    int suradnicaY = scanner.nextInt();
                    this.plocha.makeGuess(suradnicaY, suradnicaX);
                    break;
                case 2:
                    System.out.println("Zadaj X: ");
                    suradnicaX = scanner.nextInt();
                    System.out.println("Zadaj Y: ");
                    suradnicaY = scanner.nextInt();
                    this.plocha.polozVlajku(suradnicaY, suradnicaX);
                    break;
                case 3:
                    System.out.println("Toto este dorobim, skus vyberat este raz a teraz lepsie");
                    this.makeGuesses();
                    break;
                default:
                    System.out.println("Chybný input, skús ešte raz");
            }
            this.makeGuesses();
        }
    }
}
import java.util.Scanner;

public class userInput {
    private Plocha plocha;
    private Scanner scanner;
    
    public userInput() {
        this.scanner = new Scanner(System.in);
        this.vytvorPlochu();
        this.vytvorPoleMin();
        this.makeGuesses();
    }

    public void vytvorPlochu(){
        System.out.println("Pocet riadkov: "); 
        int riadky = scanner.nextInt(); 

        System.out.println("Pocet stlpcov: "); 
        int stlpce = scanner.nextInt(); 
        
        this.plocha = new Plocha(riadky, stlpce);
    }
    
    public void vytvorPoleMin(){
        System.out.println("Zadaj pocet min: ");
        int pocetMin = scanner.nextInt();
        this.plocha.vytvorPoleBomb(pocetMin);
    }
    
    public void makeGuesses(){
        if(!this.plocha.getVyhra() && !this.plocha.getPrehra()){
            System.out.println("Vyber: odhad(1), poloz vlajku(2): ");
            int vyber = scanner.nextInt();
            
            if (vyber==1){
                System.out.println("Zadaj X: ");
                int suradnicaX = scanner.nextInt();
                
                System.out.println("Zadaj Y: ");
                int suradnicaY = scanner.nextInt();
                this.plocha.makeGuess(suradnicaY, suradnicaX);
            }
            else{
                System.out.println("Zadaj X: ");
                int suradnicaX = scanner.nextInt();
                
                System.out.println("Zadaj Y: ");
                int suradnicaY = scanner.nextInt();
                this.plocha.polozVlajku(suradnicaY, suradnicaX);
            }
            this.makeGuesses();
        }
    }
}
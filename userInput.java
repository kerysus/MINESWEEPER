import java.util.Scanner;
public class userInput {

    public userInput() {
        
    }
    
    public Plocha vytvorPlochu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pocet riadkov: "); 
        int riadky = scanner.nextInt(); 
        
        System.out.println("Pocet stlpcov: "); 
        int stlpce = scanner.nextInt(); 
        
        Plocha plocha1 = new Plocha(riadky, stlpce);
        return plocha1;
    }
    
    public Plocha makeAGuess(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("X: "); 
        int x = scanner.nextInt(); 
        
        System.out.println("Y: "); 
        int y = scanner.nextInt(); 
        
        
    }
}

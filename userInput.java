import java.util.Scanner;
public class userInput {
    private Plocha plocha;
    
    public userInput() {
        this.vytvorPlochu();
    }

    public void vytvorPlochu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pocet riadkov: "); 
        int riadky = scanner.nextInt(); 

        System.out.println("Pocet stlpcov: "); 
        int stlpce = scanner.nextInt(); 
        
        this.plocha = new Plocha(riadky, stlpce);
        
    }
}
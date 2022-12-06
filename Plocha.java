import java.util.ArrayList;
/**
 * Write a description of class Plocha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plocha {
    Policko[][] zoznamPolicok;
    private int riadky;
    private int stlpce;
    private int bombCount;
    private boolean gameOver;
    public Plocha(int riadky, int stlpce) {
        this.zoznamPolicok = new Policko[riadky][stlpce];
        this.vytvorPlochu(riadky, stlpce);
        this.gameOver = false;
    }
    
    public void vytvorPlochu(int riadky, int stlpce){
        this.riadky = riadky;
        this.stlpce = stlpce;
        for (int i = 0; i < riadky; i++){
            for (int j = 0; j < riadky; j++){
                zoznamPolicok[i][j] = new Policko(i, j);
                zoznamPolicok[i][j].vykresli();
            }
            System.out.println("");
        }
    }
    
    public void updatePlocha(int riadky, int stlpce){
        for (int i = 0; i < riadky; i++){
            for (int j = 0; j < riadky; j++){
                zoznamPolicok[i][j].vykresli();
            }
            System.out.println("");
        }
    }
    
    public void vytvorBombu(int x, int y){
        zoznamPolicok[x-1][y-1].vytvorBombu();
        System.out.println("----------------------------------");
        System.out.println("");
        updatePlocha(this.riadky, this.stlpce);
    }
    
    public void nieJeBomba(int x, int y, int pocetBomb){
        this.zoznamPolicok[x-1][y-1].nieJeBomba(x, y, pocetBomb);
    }
    
    public void makeGuess(int x, int y){
        this.bombCount=0;
        
        if (zoznamPolicok[x-1][y-1].getJeBomba()){
            this.gameOver = true;
            System.out.println("Prehral si hru, gg wp");
        }
        for (int riadok = 0; riadok < 3; riadok++){
            for (int policko = 0; policko < 3; policko++){
                if (zoznamPolicok[(x-2)+riadok][(y-2)+policko].getJeBomba()){
                    System.out.println("ano");
                    this.bombCount++;
                }
                else{
                    System.out.println("ne");
                    this.nieJeBomba(x, y, this.bombCount);
                }
            }
        }
        System.out.println("bomCount: " + this.bombCount);
        updatePlocha(this.riadky, this.stlpce);
    }
}

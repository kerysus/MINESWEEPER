import java.util.ArrayList;
import java.util.Random;
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
    private int pocetBomb;
    private Random random;
    private boolean gameOver;
    private int zneskodneneBomby;
    
    public Plocha(int riadky, int stlpce) {
        this.zoznamPolicok = new Policko[riadky][stlpce];
        this.vytvorPlochu(riadky, stlpce);
        this.gameOver = false;
        this.random = new Random();
        this.zneskodneneBomby = 0;
    }
    
    public boolean getGameOver(){
        return this.gameOver;
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
        System.out.println("=====================================================");
    }
    
    public void vytvorPoleBomb(int pocetBomb){
        //int pocetPolicok = this.riadky*this.stlpce;
        //int pocetBomb = this.pocetBomb/5;
        this.pocetBomb = pocetBomb;
        System.out.println("--------------------");
        for (int i = 0; i < pocetBomb; i++){
            int randX = this.random.nextInt(1, this.riadky);
            int randY = this.random.nextInt(1, this.stlpce);
            this.vytvorBombu(randX, randY);        
        }
        this.updatePlocha(this.riadky, this.stlpce);
    }
    
    public void vytvorBombu(int x, int y){
        this.zoznamPolicok[x-1][y-1].vytvorBombu();
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
        this.updatePlocha(this.riadky, this.stlpce);
    }
    
    public void polozVlajku(int x, int y){
        if (this.zoznamPolicok[x-1][y-1].getJeBomba()){
            this.zneskodneneBomby++;
            if (this.zneskodneneBomby==this.pocetBomb){
                System.out.println("VYHRAL SI!");
            }
        }
        this.zoznamPolicok[x-1][y-1].setMaVlajku(true);
        this.updatePlocha(this.riadky, this.stlpce);
    }
}

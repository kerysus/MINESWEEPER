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
    public Plocha(int riadky, int stlpce) {
        zoznamPolicok = new Policko[riadky][stlpce];
        vytvorPlochu(riadky, stlpce);
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
        zoznamPolicok[x][y].vytvorBombu();
        System.out.println("----------------------------------");
        System.out.println("");
        updatePlocha(this.riadky, this.stlpce);
    }
    
}

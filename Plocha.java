import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Random;

public class Plocha {
    private int riadky;
    private int stlpce;
    private int pocetBomb;
    private int zneskodneneBomby;
    private boolean vyhra;
    private boolean prehra;
    private Random random;
    private VykresliPrazdnePolicka vykresliPrazdnePolicka;
    Policko[][] zoznamPolicok;
    
    public Plocha(int riadky, int stlpce) {
        this.zoznamPolicok = new Policko[riadky][stlpce];
        this.vytvorPlochu(riadky, stlpce);
        this.vyhra = false;
        this.prehra = false;
        this.random = new Random();
        this.zneskodneneBomby = 0;
    }
    
    public boolean getVyhra(){
        return this.vyhra;
    }
    
    public boolean getPrehra(){
        return this.prehra;
    }
    
    //nastavi atribut "jeBomba" daneho policka (miny) na false 
    public void setJeBomba(int x, int y, boolean hodnota){
        this.zoznamPolicok[x-1][y-1].setJeBomba(hodnota);
    }
    
    public void setBombsInArea(int x, int y, int pocet){
        this.zoznamPolicok[x-1][y-1].setBombsInArea(pocet);
    }
    
    public void setJeOdhalena(int x, int y, boolean hodnota){
        this.zoznamPolicok[x-1][y-1].setJeOdhalena(hodnota);
    }
    
    //vytvori novy objekt typu Plocha()
=======
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
    
>>>>>>> 8a3faf07d60e13b591ee5e9f08e1beb5f1b99121
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
    
<<<<<<< HEAD
    //vykresli hracu plochu hry
    public void updatePlocha(int riadky, int stlpce){
        System.out.print("   ");
        for (int x = 1; x <= stlpce; x++){
            if (x > 9){
                System.out.print(" " + x + "  ");
            }
            else{
                System.out.print("  " + x + "  ");
            }
        }
        System.out.println("");
        System.out.print("   ");
        for (int j = 1; j <= stlpce; j++){
            System.out.print("======");
        }
        System.out.println("");
        
        for (int i = 0; i < riadky; i++){
            if ((i+1)<10){
                System.out.print((i+1) + "| ");
            }
            else{
                System.out.print((i+1) + "|");
            }
<<<<<<< HEAD
            
            
=======
=======
    public void updatePlocha(int riadky, int stlpce){
        for (int i = 0; i < riadky; i++){
>>>>>>> 8a3faf07d60e13b591ee5e9f08e1beb5f1b99121
>>>>>>> 33b1d910da037c99ea8f5ee01e334396f33ff083
            for (int j = 0; j < riadky; j++){
                    zoznamPolicok[i][j].vykresli();     
            }
            System.out.println("");
        }
<<<<<<< HEAD
        
        for (int j = 1; j <= stlpce; j++){
            System.out.print("======");
        }
        System.out.println("");
=======
<<<<<<< HEAD
        System.out.println("=====================================================");
>>>>>>> 33b1d910da037c99ea8f5ee01e334396f33ff083
    }
    
    //vytvori minu na danej suradnici
    public void vytvorBombu(int x, int y){
        this.zoznamPolicok[x-1][y-1].vytvorBombu();
    }
    
    //vytvori dany pocet min na ploche
    public void vytvorPoleBomb(int pocetBomb){
        this.pocetBomb = pocetBomb;
        for (int i = 0; i < pocetBomb; i++){
            int randX = this.random.nextInt(1, this.riadky);
            int randY = this.random.nextInt(1, this.stlpce);
            this.vytvorBombu(randX, randY);        
        }
        this.zistiPocetMinOkoloVsetkychPolicok();
        this.updatePlocha(this.riadky, this.stlpce);
    }
    
    //metoda na vytvorenie odhadu kde by sa mina mohla nachadzat
    public void makeGuess(int x, int y){
        //skontroluje ci sme trafili minu
        if (zoznamPolicok[x-1][y-1].getJeBomba()){
            this.prehra = true;
            System.out.println("Prehral si hru, gg wp");
        }
        //ak sme minu netrafili, vypise cislo s poctom min na danej suradnici
        else{
            this.zoznamPolicok[x-1][y-1].setJeOdhalena(true);
            System.out.println("bombCount: " + this.zoznamPolicok[x-1][y-1].getBombsInArea());
            this.updatePlocha(this.riadky, this.stlpce);
            
            if (this.zoznamPolicok[x-1][y-1].getBombsInArea()==0){
                this.vykresliPrazdnePolicka = new VykresliPrazdnePolicka(this.zoznamPolicok, x, y);
            }
        }
    }
    
    //metoda na zistenie kolko je min v okoli daneho policka
    public int zistiPocetMinOkolo(int x, int y){
        int pocetMinOkolo = 0;
        for (int riadok = 0; riadok < 3; riadok++){
                for (int policko = 0; policko < 3; policko++){
                    int index1 = (x-2)+riadok;
                    int index2 = (y-2)+policko;
                    if ((index1 == -1 || index2 == -1) || (index1 == this.zoznamPolicok[x-1].length || index2 == this.zoznamPolicok.length)){
                        continue;
                    }
                    else{
                        if (zoznamPolicok[index1][index2].getJeBomba()){
                            pocetMinOkolo++;
                        }
                        else{
                            this.setBombsInArea(x, y, pocetMinOkolo);
                        }
                    } 
                }
            }
        return pocetMinOkolo;
    }
    
    public void zistiPocetMinOkoloVsetkychPolicok(){
        for (int riadok = 0; riadok < this.zoznamPolicok.length; riadok++){
            for (int prvok = 0; prvok < this.zoznamPolicok[riadok].length; prvok++){   
                this.zoznamPolicok[riadok][prvok].setBombsInArea(this.zistiPocetMinOkolo(riadok+1, prvok+1));
            }
        }
    }
    
    //skontroluje ci sme polozili vlajku na minu, ak ano pripocitaju sa nam vitazne body
    public void polozVlajku(int x, int y){
        if (this.zoznamPolicok[x-1][y-1].getJeBomba()){
            this.zneskodneneBomby++;
            if (this.zneskodneneBomby==this.pocetBomb){
                System.out.println("VYHRAL SI!");
                this.vyhra = true;
            }
            else{
                this.zoznamPolicok[x-1][y-1].setMaVlajku(true);
                this.updatePlocha(this.riadky, this.stlpce);
            }
        }
        else{
            this.zoznamPolicok[x-1][y-1].setMaVlajku(true);
            this.updatePlocha(this.riadky, this.stlpce);
        } 
    }  
=======
    }
    
    public void vytvorBombu(int x, int y){
        zoznamPolicok[x][y].vytvorBombu();
        System.out.println("----------------------------------");
        System.out.println("");
        updatePlocha(this.riadky, this.stlpce);
    }
    
>>>>>>> 8a3faf07d60e13b591ee5e9f08e1beb5f1b99121
}


/**
 * Write a description of class mina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Policko {
    private int x;
    private int y;
<<<<<<< HEAD
    private int bombsInArea;
    private boolean jeBomba;
    private boolean jeVedlaBomba;
    private boolean jeOdhalena;
    private boolean maVlajku;
    private boolean obsadene;

    public Policko(int y, int x) {
        this.x = x;
        this.y = y;
        this.jeOdhalena = false;
        this.jeVedlaBomba = false;
        this.jeBomba = false;
        this.maVlajku = false;
        this.obsadene = false;
=======
    private boolean jeBomba = false;
    public Policko(int y, int x) {
        this.x = x;
        this.y = y;
>>>>>>> 8a3faf07d60e13b591ee5e9f08e1beb5f1b99121
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
<<<<<<< HEAD
    public int getBombsInArea(){
        return this.bombsInArea;
    }
    
=======
>>>>>>> 8a3faf07d60e13b591ee5e9f08e1beb5f1b99121
    public boolean getJeBomba(){
        return this.jeBomba;
    }
    
<<<<<<< HEAD
    public boolean getJeObsadene(){
        return this.obsadene;
    }
    
    public boolean getMaVlajku(){
        return this.maVlajku;
    }
    
    public void setJeObsadene(boolean hodnota){
        this.obsadene = hodnota;
    }

    public void setMaVlajku(boolean hodnota){
        this.maVlajku = hodnota;
    }
    
    public void setJeBomba(boolean hodnota){
        this.jeBomba = hodnota;
    }
    
    public void setJeOdhalena(boolean hodnota){
        this.jeOdhalena = hodnota;
    }
    
    public void setBombsInArea(int pocet){
        this.bombsInArea = pocet;
    }
    
    public boolean makeGuess(int x, int y){
        return false;
    }
    
=======
>>>>>>> 8a3faf07d60e13b591ee5e9f08e1beb5f1b99121
    public void vytvorBombu(){
        this.jeBomba = true;
    }
    
<<<<<<< HEAD
    //vykresli dane policko podla toho aky ma stav
    public void vykresli(){
        if (this.jeOdhalena){
            if (this.bombsInArea==0){
                System.out.print("     ");
                this.obsadene = true;
            }
            else {
                System.out.print(" |" + this.bombsInArea + "| ");
            }
        }     
        
        else if (this.maVlajku){
            if (this.bombsInArea==0){
                this.obsadene = true;
            }
                System.out.print(" |P| ");
            }
        
        else {
            if (this.bombsInArea==0){
                this.obsadene = true;
            }
            
            if (this.jeBomba){
                System.out.print(" |*| ");
            }
            else{
                System.out.print(" |0| ");
            }
            }
        }
=======
    public void vykresli(){
        if (this.getJeBomba() == true) {
            System.out.print(" * ");
        }
        else {
            System.out.print(" 0 ");
        }
    }
>>>>>>> 8a3faf07d60e13b591ee5e9f08e1beb5f1b99121
}

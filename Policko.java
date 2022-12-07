
/**
 * Write a description of class mina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Policko {
    private int x;
    private int y;
    private boolean jeBomba;
    private boolean jeVedlaBomba;
    private boolean jeOdhalena;
    private boolean maVlajku;
    private int bombCount;
    public Policko(int y, int x) {
        this.x = x;
        this.y = y;
        this.jeOdhalena = false;
        this.jeVedlaBomba = false;
        this.jeBomba = false;
        this.maVlajku = false;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public boolean getJeBomba(){
        return this.jeBomba;
    }
    
    public boolean makeGuess(int x, int y){
        return false;
    }
    
    public boolean getMaVlajku(){
        return this.maVlajku;
    }
    
    public void setMaVlajku(boolean hodnota){
        this.maVlajku = hodnota;
    }
    
    public void vytvorBombu(){
        this.jeBomba = true;
    }
    
    public void setNieJeBomba(int x, int y, int pocetBomb){
        this.jeBomba = false;
        this.jeOdhalena = true;
        this.bombCount = pocetBomb;
    }
    
    public void vykresli(){
        if (this.getJeBomba()) {
            System.out.print(" |*| ");
        }
        else if (this.jeOdhalena){
            System.out.print(" |" + this.bombCount + "| ");
        }        
        else if (this.maVlajku){
            System.out.print(" |P| ");
        }
        else {
            System.out.print(" |0| ");
        }
    }
}


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
    private int bombCount;
    public Policko(int y, int x) {
        this.x = x;
        this.y = y;
        this.jeOdhalena = false;
        this.jeVedlaBomba = false;
        this.jeBomba = false;
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
    
    public void vytvorBombu(){
        this.jeBomba = true;
    }
    
    public void nieJeBomba(int x, int y, int pocetBomb){
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
        else {
            System.out.print(" |0| ");
        }
    }
}


/**
 * Write a description of class mina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Policko {
    private int x;
    private int y;
    private boolean jeBomba = false;
    private boolean jeVedlaBomba = false;
    public Policko(int y, int x) {
        this.x = x;
        this.y = y;
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
    
    public void vykresli(){
        if (this.getJeBomba() == true) {
            System.out.print(" * ");
        }
        else {
            System.out.print(" 0 ");
        }
    }
}

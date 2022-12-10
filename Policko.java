/**
 * Write a description of class mina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Policko {
    private int x;
    private int y;
    private int bombsInArea;
    private boolean jeBomba;
    private boolean jeVedlaBomba;
    private boolean jeOdhalena;
    private boolean maVlajku;
    private boolean obsadene;
    private boolean kontrola;

    public Policko(int y, int x) {
        this.x = x;
        this.y = y;
        this.jeOdhalena = false;
        this.jeVedlaBomba = false;
        this.jeBomba = false;
        this.maVlajku = false;
        this.obsadene = false;
        this.kontrola = false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getBombsInArea() {
        return this.bombsInArea;
    }

    public boolean getJeBomba() {
        return this.jeBomba;
    }

    public boolean getJeObsadene() {
        return this.obsadene;
    }

    public boolean getMaVlajku() {
        return this.maVlajku;
    }

    public boolean getKontrola() {
        return this.kontrola;
    }

    public void setJeObsadene(boolean hodnota) {
        this.obsadene = hodnota;
    }

    public void setMaVlajku(boolean hodnota) {
        this.maVlajku = hodnota;
    }

    public void setJeBomba(boolean hodnota) {
        this.jeBomba = hodnota;
    }

    public void setJeOdhalena(boolean hodnota) {
        this.jeOdhalena = hodnota;
    }

    public void setBombsInArea(int pocet) {
        this.bombsInArea = pocet;
    }

    public void setKontrola(boolean hodnota) {
        this.kontrola = hodnota;
    }

    public boolean makeGuess(int x, int y) {
        return false;
    }

    public void vytvorBombu() {
        this.jeBomba = true;
    }

    //vykresli dane policko podla toho aky ma stav
    public void vykresli() {
        if (this.jeOdhalena) {
            if (this.bombsInArea == 0) {
                System.out.print("     ");
            } else {
                System.out.print(" |" + this.bombsInArea + "| ");
            }
        } else if (this.maVlajku) {
            System.out.print(" |P| ");
        } else {
            System.out.print(" |0| ");
        }
    }
}
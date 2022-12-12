/**
 * Táto trieda nastaví počiatočné parametre políčku v hre. 
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
    
    /**
     * Táto metóda tvorí konštruktor triedy.
     */
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
    
    /**
     * Táto metóda tvorí getter pre atribút x.
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Táto metóda tvorí getter pre atribút y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Táto metóda tvorí getter pre atribút bombsInArea.
     */
    public int getBombsInArea() {
        return this.bombsInArea;
    }
    
    /**
     * Táto metóda tvorí getter pre atribút jeBomba.
     */
    public boolean getJeBomba() {
        return this.jeBomba;
    }

    /**
     * Táto metóda tvorí getter pre atribút obsadene.
     */
    public boolean getJeObsadene() {
        return this.obsadene;
    }
    
    /**
     * Táto metóda tvorí getter pre atribút maVlajku.
     */
    public boolean getMaVlajku() {
        return this.maVlajku;
    }
    
    /**
     * Táto metóda tvorí getter pre atribút kontrola.
     */
    public boolean getKontrola() {
        return this.kontrola;
    }

    /**
     * Táto metóda tvorí setter pre atribút obsadene.
     */
    public void setJeObsadene(boolean hodnota) {
        this.obsadene = hodnota;
    }
    
    /**
     * Táto metóda tvorí setter pre atribút maVlajku.
     */
    public void setMaVlajku(boolean hodnota) {
        this.maVlajku = hodnota;
    }
    
    /**
     * Táto metóda tvorí setter pre atribút jeBomba.
     */
    public void setJeBomba(boolean hodnota) {
        this.jeBomba = hodnota;
    }
    
    /**
     * Táto metóda tvorí setter pre atribút jeOdhalena.
     */
    public void setJeOdhalena(boolean hodnota) {
        this.jeOdhalena = hodnota;
    }
    
    /**
     * Táto metóda tvorí setter pre atribút bombsInArea.
     */
    public void setBombsInArea(int pocet) {
        this.bombsInArea = pocet;
    }

    /**
     * Táto metóda tvorí setter pre atribút kontrola.
     */
    public void setKontrola(boolean hodnota) {
        this.kontrola = hodnota;
    }
    
    /**
     * Táto metóda nastaví atribút jeBomba typu boolean na true.
     */
    public void vytvorBombu() {
        this.jeBomba = true;
    }

    /**
     * Táto metóda vykreslí stav políčka na plochu.
     */
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

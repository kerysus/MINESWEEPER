import java.util.Random;

/**
 * Táto trieda vypíše vytvorí a vykreslí plochu do terminálu.
 */
public class Plocha {
    private int riadky;
    private int stlpce;
    private int pocetBomb;
    private int zneskodneneBomby;
    private boolean vyhra;
    private boolean prehra;
    private Random random;
    private VykresliPrazdnePolicka vykresliPrazdnePolicka;
    private Policko[][] zoznamPolicok;
    
    /**
     * Táto metóda tvorí konštruktor triedy.
     */
    public Plocha(int riadky, int stlpce) {
        this.zoznamPolicok = new Policko[riadky][stlpce];
        this.vytvorPlochu(riadky, stlpce);
        this.vyhra = false;
        this.prehra = false;
        this.random = new Random();
        this.zneskodneneBomby = 0;
    }
    
    /**
     * Táto metóda tvorí getter na atribút vyhra.
     */
    public boolean getVyhra() {
        return this.vyhra;
    }
    
    /**
     * Táto metóda tvorí getter na atribút prehra.
     */
    public boolean getPrehra() {
        return this.prehra;
    }

    /**
     * Táto metóda nastaví atribút jeBomba daného políčka na false.
     */
    public void setJeBomba(int x, int y, boolean hodnota) {
        this.zoznamPolicok[x - 1][y - 1].setJeBomba(hodnota);
    }
    
    /**
     * Táto metóda volá metódu setBombsInArea triedy Policko.
     */
    public void setBombsInArea(int x, int y, int pocet) {
        this.zoznamPolicok[x - 1][y - 1].setBombsInArea(pocet);
    }
    
    /**
     * Táto metóda volá metódu setJeOdhalena triedy Policko.
     */
    public void setJeOdhalena(int x, int y, boolean hodnota) {
        this.zoznamPolicok[x - 1][y - 1].setJeOdhalena(hodnota);
    }

    /**
     * Táto metóda vytvorí a vykreslí hraciu plochu na terminál.
     */
    public void vytvorPlochu(int riadky, int stlpce) {
        this.riadky = riadky;
        this.stlpce = stlpce;
        for (int i = 0; i < riadky; i++) {
            for (int j = 0; j < riadky; j++) {
                this.zoznamPolicok[i][j] = new Policko(i, j);
                this.zoznamPolicok[i][j].vykresli();
            }
            System.out.println("");
        }
    }

    /**
     * Táto metóda aktualizuje plochu a vypíše ju s hodnotami každého políčka.
     */
    public void updatePlocha(int riadky, int stlpce) {
        System.out.print("   ");
        for (int x = 1; x <= stlpce; x++) {
            if (x > 9) {
                System.out.print(" " + x + "  ");
            } else {
                System.out.print("  " + x + "  ");
            }
        }
        System.out.println("");
        System.out.print("   ");
        for (int j = 1; j <= stlpce; j++) {
            System.out.print("======");
        }
        System.out.println("");

        for (int i = 0; i < riadky; i++) {
            if ((i + 1) < 10) {
                System.out.print((i + 1) + "| ");
            } else {
                System.out.print((i + 1) + "|");
            }


            for (int j = 0; j < riadky; j++) {
                this.zoznamPolicok[i][j].vykresli();
            }
            System.out.println("");
        }

        for (int j = 1; j <= stlpce; j++) {
            System.out.print("======");
        }
        System.out.println("");
    }

    /**
     * Táto metóda vytvorí mínu na danej súradnici.
     */
    public void vytvorBombu(int x, int y) {
        this.zoznamPolicok[x - 1][y - 1].vytvorBombu();
    }

    /**
     * Táto metóda vytvorí daný počet mín na ploche.
     */
    public void vytvorPoleBomb(int pocetBomb) {
        this.pocetBomb = pocetBomb;
        for (int i = 0; i < pocetBomb; i++) {
            int randX = this.random.nextInt(1, this.riadky);
            int randY = this.random.nextInt(1, this.stlpce);
            this.vytvorBombu(randX, randY);    
        }
        this.zistiPocetMinOkoloVsetkychPolicok();
        this.updatePlocha(this.riadky, this.stlpce);
    }

    /**
     * Táto metóda slúži na kontrolu či sme trafili alebo netrafili mínu.
     */
    public void makeGuess(int x, int y) {
        //skontroluje ci sme trafili minu
        if (this.zoznamPolicok[x - 1][y - 1].getJeBomba()) {
            this.prehra = true;
            System.out.println("TRAFIL SI MÍNU, HRU SI PREHRAL!");
        } else {
            //ak sme minu netrafili, vypise cislo s poctom min na danej suradnici
            this.zoznamPolicok[x - 1][y - 1].setJeOdhalena(true);
            this.updatePlocha(this.riadky, this.stlpce);

            if (this.zoznamPolicok[x - 1][y - 1].getBombsInArea() == 0) {
                this.vykresliPrazdnePolicka = new VykresliPrazdnePolicka(this.zoznamPolicok, x, y);
                this.vykresliPrazdnePolicka.algoritmus();
                this.zoznamPolicok = this.vykresliPrazdnePolicka.getZoznamPraznychPoli();
                this.vykresliPrazdnePolia();
            }
        }
    }
    
    /**
     * Táto metóda vykreslí polia ktoré sú prázdne.
     */
    public void vykresliPrazdnePolia() {
        for (int riadok = 0; riadok < this.zoznamPolicok.length; riadok++) {
            for (int prvok = 0; prvok < this.zoznamPolicok[riadok].length; prvok++) {
                if (this.zoznamPolicok[riadok][prvok].getKontrola()) {
                    this.zoznamPolicok[riadok][prvok].setJeOdhalena(true);
                }
            }
        }
        this.updatePlocha(this.riadky, this.stlpce);
    }

    /**
     * Táto metóda zistí počet mín akolo daného políčka.
     */
    public int zistiPocetMinOkolo(int x, int y) {
        int pocetMinOkolo = 0;
        for (int riadok = 0; riadok < 3; riadok++) {
            for (int policko = 0; policko < 3; policko++) {
                int index1 = (x - 2) + riadok;
                int index2 = (y - 2) + policko;
                if ((index1 == -1 || index2 == -1) || (index1 == this.zoznamPolicok[x - 1].length || index2 == this.zoznamPolicok.length)) {
                    continue;
                } else {
                    if (this.zoznamPolicok[index1][index2].getJeBomba()) {
                        pocetMinOkolo++;
                    } else {
                        this.setBombsInArea(x, y, pocetMinOkolo);
                    }
                }
            }
        }
        return pocetMinOkolo;
    }
    
    /**
     * Táto metóda zistí počet mín okolo všetkých políčok.
     */
    public void zistiPocetMinOkoloVsetkychPolicok() {
        for (int riadok = 0; riadok < this.zoznamPolicok.length; riadok++) {
            for (int prvok = 0; prvok < this.zoznamPolicok[riadok].length; prvok++) {
                int pocetMinOkolo = this.zistiPocetMinOkolo(riadok + 1, prvok + 1);
                if (pocetMinOkolo == 0) {
                    this.zoznamPolicok[riadok][prvok].setJeObsadene(true);
                }
                this.zoznamPolicok[riadok][prvok].setBombsInArea(pocetMinOkolo);
            }
        }
    }
    
    /**
     * Táto metóda skontroluje či sme položili vlajku na mínu, ak áno, pripočítajú sa víťazné body.
     */
    public void polozVlajku(int x, int y) {
        if (this.zoznamPolicok[x - 1][y - 1].getJeBomba()) {
            this.zneskodneneBomby++;
            if (this.zneskodneneBomby == this.pocetBomb) {
                System.out.println("VYHRAL SI!");
                this.vyhra = true;
            } else {
                this.zoznamPolicok[x - 1][y - 1].setMaVlajku(true);
                this.updatePlocha(this.riadky, this.stlpce);
            }
        } else {
            this.zoznamPolicok[x - 1][y - 1].setMaVlajku(true);
            this.updatePlocha(this.riadky, this.stlpce);
        }
    }
    
    /**
     * Táto metóda zdvihne vlajku z daného políčka.
     */
    public void zdvihniVlajku(int x, int y) {
        this.zoznamPolicok[x - 1][y - 1].setMaVlajku(false);
        this.updatePlocha(this.riadky, this.stlpce);
    }
}

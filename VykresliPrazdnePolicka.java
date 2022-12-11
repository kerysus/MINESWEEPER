import java.util.ArrayList;
public class VykresliPrazdnePolicka {
    private Policko[][] zoznamPolicok;
    private int suradnicaX;
    private int suradnicaY;
    private Policko[] polickaArray;
    private ArrayList < Policko > polickaList;
    private boolean logic;

    public VykresliPrazdnePolicka(Policko[][] zoznamMin, int suradnicaX, int suradnicaY) {
        this.zoznamPolicok = zoznamMin;
        this.suradnicaX = suradnicaX - 1;
        this.suradnicaY = suradnicaY - 1;
        this.polickaList = new ArrayList < Policko > ();
        this.algoritmus();
    }

    public void algoritmus() {
        //kontroluje kazde policko akolo daneho policka
        for (int riadok = 0; riadok < 3; riadok++) {
            for (int policko = 0; policko < 3; policko++) {
                int index1 = (this.suradnicaX - 1) + riadok;
                int index2 = (this.suradnicaY - 1) + policko;
                if (index1 < 0 || index2 < 0) {
                    continue;
                }
                if ((index1 == this.zoznamPolicok[this.suradnicaX].length) || (index2 == this.zoznamPolicok.length)) {
                    continue;
                } else {
                    if (this.zoznamPolicok[index2][index1].getJeBomba()) {
                        this.zoznamPolicok[index1][index2].setKontrola(true);
                        this.zoznamPolicok[index1][index2].setJeOdhalena(true);
                    } else {
                        this.zoznamPolicok[index1][index2].setKontrola(true);
                        this.zoznamPolicok[index1][index2].setJeOdhalena(true);
                    }
                }
            }
        }
    }

    public Policko[][] getZoznamPraznychPoli() {
        return this.zoznamPolicok;
    }

    public void vypisHodnot() {
        for (int riadok = 0; riadok < this.zoznamPolicok.length; riadok++) {
            for (int prvok = 0; prvok < this.zoznamPolicok[riadok].length; prvok++) {
                System.out.print(this.zoznamPolicok[riadok][prvok].getKontrola() + " ");
            }
            System.out.println("");
        }
    }

}

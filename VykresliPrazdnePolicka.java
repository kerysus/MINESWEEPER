import java.util.ArrayList;
public class VykresliPrazdnePolicka
{
    private Policko[][] zoznamPolicok;
    private int suradnicaX;
    private int suradnicaY;
    
    public VykresliPrazdnePolicka(Policko[][] zoznamMin, int suradnicaX, int suradnicaY)
    {
        this.zoznamPolicok = zoznamMin;
        this.suradnicaX = suradnicaX;
        this.suradnicaY = suradnicaY;
        this.algoritmus();
    }

    public void algoritmus(){
        
        this.vypisHodnot();
    }
    
    public void vlavo(Policko policko){
    }
    
    public void vpravo(ArrayList<Policko> zoznamPrazdnych){
    
    }
    
    public void hore(ArrayList<Policko> zoznamPrazdnych){
    
    }
    
    public void dole(ArrayList<Policko> zoznamPrazdnych){
        
    }
    
    public void vypisHodnot(){
        for (int riadok = 0; riadok < this.zoznamPolicok.length; riadok++){
            for (int prvok = 0; prvok < this.zoznamPolicok[riadok].length; prvok++){
                System.out.print(this.zoznamPolicok[riadok][prvok].getJeObsadene()+" ");
            }
            System.out.println("");
        }
    }

}

/**
 * Táto trieda vypíše do konzole nápovedu ako sa hra má hrať a logo ZŤP.
 */
public class Napoveda {
    /**
     * Táto metóda tvorí konštruktor triedy, v ktorej volá len jednu metódu.
     */
    public Napoveda() {
        this.dajNapovedu();
    }
    
    /**
     * Táto metóda vypíše do konzole nápovedu ako sa hra má hrať a logo ZŤP.
     */
    public void dajNapovedu(){
        System.out.println("                              \\\\   //");
        System.out.println("                               \\\\_//");
        System.out.println("                                \\_/");
        System.out.println("  _________________     ___________________    ________________");
        System.out.println(" /_______________ ||   ||_______   _______||  ||  __________  \\\\");
        System.out.println("              // //            || ||          || ||         \\\\ \\\\");
        System.out.println("             // //             || ||          || ||          \\\\ \\\\");
        System.out.println("            // //              || ||          || ||          || ||");
        System.out.println("           // //               || ||          || ||         // //");
        System.out.println("          // //                || ||          || ||        // //");
        System.out.println("         // //                 || ||          || ||_______// //");
        System.out.println(" _______// //______            || ||          ||   _________//");
        System.out.println("/_______    ______/            || ||          || ||");
        System.out.println("       // //                   || ||          || ||");
        System.out.println("      // //                    || ||          || ||");
        System.out.println("     // //                     || ||          || ||");
        System.out.println("    // //                      || ||          || ||");
        System.out.println("   // //                       || ||          || ||");
        System.out.println("  // //                        || ||          || ||");
        System.out.println(" // //                         || ||          || ||");
        System.out.println("// //______________            ||_||          ||_||");
        System.out.println("||________________/            |___|          |___|");
        System.out.println("");
        System.out.println("Hra sa hrá zadávaním dvoch čísiel ktoré slúžia ako číslo riadku a číslo stĺpca, ktorý si želáte označiť.");
        System.out.println("Ak sa vo Vami zvolenom políčku nachádza mína, hru prehrávate.");
    }
}

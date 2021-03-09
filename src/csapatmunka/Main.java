// <>
package csapatmunka;

import java.util.Stack;

public class Main {
    
    private static String bemenet;
    private static Stack<String> veremSeged;
    private static String lengyelForma;
    
    public static void main(String[] args) {
        bemenet = "2695-*+";
        lengyelForma = lengyelformaAtalakit(bemenet);
        System.out.println(lengyelFormaSzamol(lengyelForma));
    }
    
    public static String lengyelformaAtalakit(String bemenet) {
        int i = 0;
        while (i < bemenet.length()) {
            String akt = String.valueOf(bemenet.charAt(i));
            switch (akt) {
                case "(":
                    veremSeged.push(akt);
                    break;
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    lengyelForma+=akt;
                    break;
                case "*":
                case "/":
                case "-":
                case "+":
                    if (veremSeged.empty()) {
                        veremSeged.push(akt);
                    }
                    else {
                        while (!veremSeged.empty()) {
                            if (veremSeged.peek().equals("(") || veremSeged.peek().equals(")") || veremSeged.peek().equals("/") || veremSeged.peek().equals("*") || ((veremSeged.peek().equals("+") || veremSeged.peek().equals("-")) && (akt.equals("+") || akt.equals("-")))) {
                                lengyelForma+=veremSeged.pop();
                            }
                        }
                        veremSeged.push(akt);
                    }
                    break;
                case ")":
                    while (!veremSeged.peek().equals("(")) {
                        lengyelForma+=veremSeged.pop();
                    }
                    break;
            }
            while (!veremSeged.empty()) {
                lengyelForma+=veremSeged.pop();
            }
        }
        return lengyelForma;
    }
    
    public static double lengyelFormaSzamol(String lengyelForma){
        veremSeged = new Stack<>();
        veremSeged.clear();
            while(!lengyelForma.equals("")){
                char elem = lengyelForma.charAt(0);
                lengyelForma=lengyelForma.substring(1);
                if(!(elem=='+' || elem=='-' || elem=='*' || elem=='/')){
                    veremSeged.add(elem+"");
                }
                else//if(elem=='+' || elem=='-' || elem=='*' || elem=='/'){
                {
                    double ertek1=Double.parseDouble(veremSeged.pop());
                    double ertek2=Double.parseDouble(veremSeged.pop());
                    double eredmeny=kiszamol(ertek2,elem,ertek1);
                    veremSeged.add(eredmeny+"");
                }
            }
        return Double.parseDouble(veremSeged.pop());
    }

    private static double kiszamol(double ertek2, char elem, double ertek1) {
        double eredmeny=0;
        if(elem=='+')
            eredmeny = ertek2+ertek1;
        if(elem=='-')
            eredmeny = ertek2-ertek1;
        if(elem=='*')
            eredmeny = ertek2*ertek1;
        if(elem=='/')
            eredmeny = ertek2/ertek1;
        return eredmeny;
    }
    
}

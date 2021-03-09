// <>
package csapatmunka;

import java.util.Stack;

public class Main {
    
    private static String bemenet;
    private static Stack<String> veremSeged;
    private static String lengyelForma;
    
    public static void main(String[] args) {
        veremSeged = new Stack<>();
        bemenet = "(3*(4-5))*(3-5)";
        lengyelForma = lengyelformaAtalakit(bemenet);
        System.out.println(lengyelFormaSzamol(lengyelForma));
    }
    
    public static String lengyelformaAtalakit(String bemenet) {
        String valasz = "";
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
                    valasz += akt;
                    break;
                case "*":
                case "/":
                case "-":
                case "+":
                    while (!veremSeged.isEmpty()
                            && (veremSeged.peek().equals("(") || veremSeged.peek().equals(")") || veremSeged.peek().equals("/") || veremSeged.peek().equals("*") || ((veremSeged.peek().equals("+") || veremSeged.peek().equals("-")) && (akt.equals("+") || akt.equals("-"))))
                            && !veremSeged.peek().equals("(")) {
                        valasz += veremSeged.pop();
                    }
                    veremSeged.push(akt);
                    break;
                case ")":
                    while (!veremSeged.isEmpty() && !veremSeged.peek().equals("(")) {
                        valasz += veremSeged.pop();
                    }
                    if (!veremSeged.isEmpty() && veremSeged.peek().equals("(")) {
                        veremSeged.pop();
                    }
                    break;
            }
            i++;
        }
        while (!veremSeged.isEmpty()) {
            valasz += veremSeged.pop();
        }
        return valasz;
    }
    
    public static double lengyelFormaSzamol(String lengyelForma){
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

// <>
package csapatmunka;

import java.util.Stack;

public class Main {
    
    
    public static void main(String[] args) {
        System.out.println(lengyelFormaSzamol("2695-*+"));
    }
    
    public static double lengyelFormaSzamol(String lengyelForma){
        Stack<String> veremSeged = new Stack<>();
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

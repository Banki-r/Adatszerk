// <>
package csapatmunka;

import java.util.Stack;

public class Main {
    
    
    public static void main(String[] args) {
        System.out.println(lengyelFormaSzamol("15*"));
    }
    
    public static double lengyelFormaSzamol(String lengyelForma){
        Stack<String> veremSeged = new Stack<>();
        veremSeged.clear();
                while(!lengyelForma.equals("")){
                    char elem = lengyelForma.charAt(0);
                    lengyelForma=lengyelForma.substring(1);
                    System.out.println(lengyelForma);
                    if(!(elem=='+' || elem=='-' || elem=='*' || elem=='/')){
                        veremSeged.add(elem+"");
                        System.out.println(elem);
                    }
                    if(elem=='+' || elem=='-' || elem=='*' || elem=='/'){
                        int ertek1=Integer.parseInt(veremSeged.pop());
                        int ertek2=Integer.parseInt(veremSeged.pop());
                        double eredmeny=kiszamol(ertek2,elem,ertek1);//kellmég
                        veremSeged.add(eredmeny+"");
                    }
                }
        return Double.parseDouble(veremSeged.pop());
    }

    private static double kiszamol(int ertek2, char elem, int ertek1) {
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

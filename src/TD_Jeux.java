public class TD_Jeux {

    public static void main(String[] args) {
        resoudre(100);
    }

    public static void resoudreAux(int n, int i, int j){
        int k = 6-i-j;
        if(n==1){
            System.out.println(i+" -> "+j);
        }

        if(n>1){
            resoudreAux(n-1,i,k);
            resoudreAux(1,i,j);
            resoudreAux(n-1,k,j);
        }
    }

    public static void resoudre(int n){
        resoudreAux(n,1,3);
    }
}

public class TD_Jeux {

    public static void main(String[] args) {
        resoudre(3);
        remplir(3);
    }

    public static void resoudreAux(int n, int i, int j){
        int k = 6-i-j;
        if(n==1){
            System.out.println(i+" -> "+j);
        }

        if(n>1){
            resoudreAux(n-1,i,k);
            System.out.println(i+" -> "+j);
            resoudreAux(n-1,k,j);
        }
    }

    public static void resoudre(int n){
        resoudreAux(n,1,3);
        System.out.println("Nombre de coup = " + countCoup(n,1,3,0));
        System.out.println("Resultat de Un = 2^n -1 => "+(calculSuite(n)-1));
    }
    public static int countCoup(int n, int i, int j, int count){
        int k = 6-i-j;

        if(n==1){
            return count+=1;
        }

        if(n>1){
            count = countCoup(n-1,i,k,count);
            count = countCoup(1,i,k,count);
            count = countCoup(n-1,k,j,count);
        }

        return count;
    }
    public static int calculSuite(int n){
        if(n>0)
            return  (2 * calculSuite(n-1));
        return 1;
    }

    public void remplir(int n){
        if(n==1){
            System.out.println("*");
        }
        if(n>1){
            vider(n-1);
        }


    }
    public void vider(int n){
        if(n==1){
            System.out.println(".");
        }
         remplir(n-1);
    }
}

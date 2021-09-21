public class TD1 {

    public static void main(String[] args) {
        int[] t = {1,2,3,4,2,6};
        System.out.println(nbOccAux(2,t,0));

        char[] t2 = {'k','a','y','a','k'};
        char[] t21 = {'b','a','o','b','a','b'};
        char[] t22 = {'m','a','m','i','e'};
        estPalindrome(t2);
        estPalindrome(t21);
        estPalindrome(t22);

        int[] t3 = {0,3,3,4,5,6};
        System.out.println(croissants(t3));

        System.out.println(f(5));
    }

    public static int nbOccAux(int x, int []t, int i){
        if (i < t.length) {
            if(x==t[i]){
                return (nbOccAux(x, t, i+1)+1);
            }
            else return (nbOccAux(x, t, i+1));
        }
        return (0);
    }


    public static boolean estPalindromeAux(char []t, int i){
       if(i<(t.length)/2) {
            if (t[i] == t[t.length-i-1]) {
                return estPalindromeAux(t, i+1);
            }
            else return false;
       }
       else return true;
    }

    public static boolean estPalindrome(char []t){
        int i=0;
        String mot="";
        for(int j=0; j<t.length;j++){
            mot+=t[j];
        }
        if(estPalindromeAux(t, i))
        System.out.println("le mot "+mot+" est un palindrome");
        else System.out.println("le mot "+mot+" n'est pas un palindrome");
        return estPalindromeAux(t, i);
    }

    public static boolean croissantsAux(int []t, int i){
        if(i==t.length-1){
            return true;
        }
        if(t[i-1]<=t[i]){
            return croissantsAux(t,i+1);
        }
        else return false;
    }


    public static boolean croissants(int []t){
        int i=1;
        return croissantsAux(t,i);

    }

    public static int f(int n){
        if(n<1){
            return 1;
        }
       int count=0;
       count+=f(n-1);
       if(n>=2)
            count+=f(n-2);
       return count;
    }

    public static int PGCD(int a, int b){

        return 0;

    }
}

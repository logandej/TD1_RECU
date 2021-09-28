public class TD_Listes {

    public static void main(String[] args) {
        Liste liste = new Liste(1);
        Liste liste1 = new Liste(2, liste);
        Liste liste2 = new Liste(3, liste1);

        liste.copie(liste1);
        liste.copie(liste2);


        System.out.println(liste2.toString(liste2));

    }









}

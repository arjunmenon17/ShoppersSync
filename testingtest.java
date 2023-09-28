public class testingtest {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            int min = 0;
            int max = 1;
            int terreOuEau;
            terreOuEau = (int) (Math.random() * ((max - min) + 1)) + min;
            System.out.println("val is:"+terreOuEau);
            if (terreOuEau==1){
                System.out.println("The environment where life and its further evolution will begin is terrestrial.");
            } else {
                System.out.println("The environment where life and its further evolution will begin is aquatic.");
            }
            System.exit(0);
        }
    }
}

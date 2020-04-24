public class Heurisztika {
    private static int ertek;

    public static int h(Allapot allapot) {
        return lehetseges(allapot);
    }

    private static void ertekeles(int pozicio1, int pozicio2, Allapot allapot) {
        char[][] a = allapot.getA();
        if (a[pozicio1][pozicio2] == 0){
            ertek = ertek +1;
        }
        if (pozicio1-1>=0 && pozicio1 -2 >=0 &&pozicio2-1>=0 && pozicio2-2>=0 && pozicio1+1<8 && pozicio1+2<8 && pozicio2+1<8 && pozicio2+2<8)
        if (a[pozicio1-1][pozicio2-2] == 'B' || a[pozicio1+1][pozicio2-2] == 'B' || a[pozicio1+1][pozicio2+2] == 'B' || a[pozicio1-2][pozicio2-1] == 'B' || a[pozicio1-1][pozicio2+2] == 'B'){
            ertek = ertek +100;
        }
    }

    private static int lehetseges(Allapot allapot) {
        ertek = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j< 8; j++){
                ertekeles(i,j, allapot);
            }

        }
        return ertek;
    }

}

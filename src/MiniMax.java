public class MiniMax {

    public static Operator lepes(Allapot allapot, Problema p, int korlat, char babu) {
        int max = Integer.MIN_VALUE;
        Operator operator = p.operatorok().get(0);
        for (Operator o : p.operatorok())
            if (o.alkalmazhato(allapot, babu)) {
                Allapot uj = o.alkalmaz(allapot, babu);
                int v = ertek(p, uj, korlat - 1, babu);
                if (v > max) {
                    max = v;
                    operator = o;
                }
            }
        return operator;
    }

    private static int ertek(Problema p, Allapot allapot, int melyseg, char babu) {
        allapot.jatekosCsere();
        if (melyseg == 0) {
            return Heurisztika.h(allapot);
        } else if (allapot.jatekos == Jatekos.Szamitogep) {
            int max = Integer.MIN_VALUE;
            for (Operator o : p.operatorok())
                if (o.alkalmazhato(allapot, babu)) {
                    Allapot uj = o.alkalmaz(allapot, babu);
                    int v = ertek(p, uj, melyseg - 1, babu);
                    if (v > max)
                        max = v;
                }
            return max;
        } else {
            int min = Integer.MAX_VALUE;
            for (Operator o : p.operatorok())
                if (o.alkalmazhato(allapot, babu)) {
                    Allapot uj = o.alkalmaz(allapot, babu);
                    int v = ertek(p, uj, melyseg - 1, babu);
                    if (v < min)
                        min = v;
                }
            return min;
        }
    }
}
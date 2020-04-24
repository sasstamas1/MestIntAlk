import java.util.Objects;

public class Operator {
    private int vizszintes;
    private int fuggoleges;

    public Operator(int vizszintes, int fuggoleges) {
        this.vizszintes = vizszintes;
        this.fuggoleges = fuggoleges;
    }

    public int getVizszintes() {
        return vizszintes;
    }

    public void setVizszintes(int vizszintes) {
        this.vizszintes = vizszintes;
    }

    public int getFuggoleges() {
        return fuggoleges;
    }

    public void setFuggoleges(int fuggoleges) {
        this.fuggoleges = fuggoleges;
    }

    public Allapot alkalmaz(Allapot allapot, char babu) {
        Allapot uj = new Allapot();
        char[][] a = allapot.getA();
        char[][] b = uj.getA();
        int q =10;
        int w = 10;
        for (int i = 0; i < 8; i++)
            System.arraycopy(a[i], 0, b[i], 0, 8);
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if (b[i][j] == babu) {
                    if(i+vizszintes<8 && j+ fuggoleges<8 && i+vizszintes>=0 && j+fuggoleges>=0){
                        b[i][j] = '1';
                        q = i + vizszintes;
                        w = j + fuggoleges;
                        break;
                    }

                }
            }
        }

        b[q][w] = babu;
        uj.setA(b);
        return uj;
    }

    public boolean alkalmazhato(Allapot allapot, char babu){
        char[][] a = allapot.getA();
        if (vizszintes != 1 && vizszintes != -1 && vizszintes != 2 && vizszintes != -2) {
            return false;
        }
        if (fuggoleges != 1 && fuggoleges != -1 && fuggoleges != 2 && fuggoleges != -2) {
            return false;
        }
        if(fuggoleges == vizszintes)
            return false;
        if (fuggoleges == -1*vizszintes)
            return false;

        for(int i=0; i<8; i++)
            for(int j=0; j<8; j++){
                if(a[i][j]==babu){
                    if ( i+ vizszintes<8 && i+vizszintes>=0 && j+fuggoleges<8 && j+fuggoleges>=0){
                        if(a[i+vizszintes][j+fuggoleges]== '0'){
                            return true;
                        }
                    }
                }
            }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return vizszintes == operator.vizszintes &&
                fuggoleges == operator.fuggoleges;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vizszintes, fuggoleges);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "vizszintes=" + vizszintes +
                ", fuggoleges=" + fuggoleges +
                '}';
    }
}

import java.util.Arrays;
import java.util.Objects;

public class Allapot {
    private char[][] A = new char[8][8];
    Jatekos jatekos;

    public Allapot() {
    }

    public Allapot(Jatekos jateks, char[][] a ) {
        jatekos = jateks;
        A = a;
    }

    public Allapot(char[][] a) {
        A = a;
    }

    public char[][] getA() {
        return A;
    }

    public void setA(char[][] a) {
        A = a;
    }

    public Jatekos getJatekos() {
        return jatekos;
    }

    public void setJatekos(Jatekos jatekos) {
        this.jatekos = jatekos;
    }

    public boolean alkalmazhato_operatorok(){
        int i=0;
        int j=0;
        for(int x=0; x<8; x++) {
            for(int y=0; y<8;y++)
                if(A[x][y] == 'W'){
                    i = x;
                    j = y;
                }
        }

        if (j + 2 < 8 && i + 1 < 8) {
            if (A[i + 1][j + 2] == 0)
                return false;
        }
        if (i + 1 < 8 && j + 2 < 8) {
            if (A[i + 1][j + 2] == 0)
                return false;
        }
        if (i - 1 >= 0 && j - 2 >= 0) {
            if (A[i - 1][j - 2] == 0)
                return false;
        }
        if (i + 1 < 8 && j - 2 >= 0) {
            if (A[i + 1][j - 2] == 0)
                return false;
        }
        if (i - 1 >= 0 && j + 2 < 8) {
            if (A[i - 1][j + 2] == 0)
                return false;
        }
        if (i + 2 < 8 && j + 1 < 8) {
            if (A[i + 2][j + 1] == 0)
                return false;
        }
        if (i - 2 >= 0 && j - 1 >= 0) {
            if (A[i - 2][j - 1] == 0)
                return false;
        }
        if (i - 2 >= 0 && j + 1 < 8) {
            if (A[i - 2][j + 1] == 0)
                return false;
        }
        if (i + 2 < 8 && j - 1 >= 0) {
            if (A[i + 2][j - 1] == 0)
                return false;
        }

        return true;
    }


    public void jatekosCsere() {
        if (this.jatekos == Jatekos.Szamitogep)
            this.jatekos = Jatekos.On;
        else
            this.jatekos = Jatekos.Szamitogep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allapot allapot = (Allapot) o;
        return Arrays.equals(A, allapot.A) &&
                jatekos == allapot.jatekos;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(jatekos);
        result = 31 * result + Arrays.hashCode(A);
        return result;
    }

    @Override
    public String toString() {
        return "Allapot{" + "\n"
                + A[0][0] + ", " + A[0][1] + ", " + A[0][2] + ", " + A[0][3] + ", " + A[0][4] + ", " + A[0][5] + ", " + A[0][6] + ", " + A[0][7] + ", " + "\n"
                + A[1][0] + ", " + A[1][1] + ", " + A[1][2] + ", " + A[1][3] + ", " + A[1][4] + ", " + A[1][5] + ", " + A[1][6] + ", " + A[1][7] + ", " + "\n"
                + A[2][0] + ", " + A[2][1] + ", " + A[2][2] + ", " + A[2][3] + ", " + A[2][4] + ", " + A[2][5] + ", " + A[2][6] + ", " + A[2][7] + ", " + "\n"
                + A[3][0] + ", " + A[3][1] + ", " + A[3][2] + ", " + A[3][3] + ", " + A[3][4] + ", " + A[3][5] + ", " + A[3][6] + ", " + A[3][7] + ", " + "\n"
                + A[4][0] + ", " + A[4][1] + ", " + A[4][2] + ", " + A[4][3] + ", " + A[4][4] + ", " + A[4][5] + ", " + A[4][6] + ", " + A[4][7] + ", " + "\n"
                + A[5][0] + ", " + A[5][1] + ", " + A[5][2] + ", " + A[5][3] + ", " + A[5][4] + ", " + A[5][5] + ", " + A[5][6] + ", " + A[5][7] + ", " + "\n"
                + A[6][0] + ", " + A[6][1] + ", " + A[6][2] + ", " + A[6][3] + ", " + A[6][4] + ", " + A[6][5] + ", " + A[6][6] + ", " + A[6][7] + ", " + "\n"
                + A[7][0] + ", " + A[7][1] + ", " + A[7][2] + ", " + A[7][3] + ", " + A[7][4] + ", " + A[7][5] + ", " + A[7][6] + ", " + A[7][7] + '}';
    }
}
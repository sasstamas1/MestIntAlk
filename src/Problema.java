import java.util.ArrayList;
import java.util.List;

public class Problema {
    public Allapot kezdo() {
        return new Allapot();
    }

    static List<Operator> OPERATOROK = new ArrayList<Operator>();
    static {

        OPERATOROK.add(new Operator(1,2));
        OPERATOROK.add(new Operator(-1,-2));
        OPERATOROK.add(new Operator(1,-2));
        OPERATOROK.add(new Operator(-1,2));
        OPERATOROK.add(new Operator(2,1));
        OPERATOROK.add(new Operator(-2,-1));
        OPERATOROK.add(new Operator(2,-1));
        OPERATOROK.add(new Operator(-2,1));


    }



    public List<Operator> operatorok() {
        return OPERATOROK;
    }


}
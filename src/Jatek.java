import java.util.Scanner;


public class Jatek {
    static char[][] A = {{'B', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', 'W'}};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problema p = new Problema();
        char babu = 'W';
        Allapot allapot;

        System.out.println("Ha szeretne Ön kezdeni, akkor írja be az 1-es számot.");
        System.out.println("Ha azt szeretné, hogy a Számítógép kezdjen akkor bármilyen más számot");
        int valasztas = scanner.nextInt();
        ;

        if (valasztas == 1) {
            allapot = new Allapot(Jatekos.On, A);
            System.out.println("A játékot Ön kezdi.");
        } else {
            allapot = new Allapot(Jatekos.Szamitogep, A);
            System.out.println("A játékot a számítógép kezdi.");
        }
        System.out.println("Ez a kezdő állás:");
        System.out.println(allapot);
        System.out.println("Ön a fekete bábuval van(B)!");

        while (true) {
            Operator operator = null;
            boolean tmp;
            do {
                switch (allapot.jatekos) {
                    case Szamitogep:
                        operator = MiniMax.lepes(allapot, p, 1, 'W');
                        System.out.println("A számítógép ezt a pozíciót választotta : " );
                        System.out.println(operator);
                        babu = 'W';
                        break;
                    case On:
                        boolean asd = false;
                        System.out.println("Adja meg a kívánt lépés irányát!");
                        int i = scanner.nextInt();
                        int j = scanner.nextInt();
                        operator = new Operator(i,j);
                        for(Operator op: Problema.OPERATOROK){
                            if(op.equals(operator))
                                asd = true;
                        }
                        if (!asd){
                            System.out.println("Nem jó operátor!");
                        }
                        babu = 'B';
                        break;
                }

            } while (!operator.alkalmazhato(allapot,babu));
            Jatekos jatekos = allapot.getJatekos();
            allapot = operator.alkalmaz(allapot, babu);
            if (!allapot.alkalmazhato_operatorok()){
                System.out.println(allapot.jatekos + " nyert!");
                break;
            }
            if (jatekos == Jatekos.Szamitogep){
                allapot.setJatekos(Jatekos.On);
            }
            else allapot.setJatekos(Jatekos.Szamitogep);
            System.out.println(allapot);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
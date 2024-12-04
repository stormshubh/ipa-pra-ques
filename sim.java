import java.util.*;

class Sim {
    public int id;
    public String cn;
    public double bal;
    public double rps;
    public String cir;

    public Sim(int id, String cn, double bal, double rps, String cir) {
        this.id = id;
        this.cn = cn;
        this.bal = bal;
        this.rps = rps;
        this.cir = cir;
    }
}

public class Main {
    public static Sim[] transferCusCir(Sim[] sims, String cir1, String cir2) {
        int ctr = 0;
        for (Sim sim : sims) {
            if (sim.cir.equals(cir1)) {
                ctr++;
            }
        }
        Sim[] val = new Sim[ctr];
        int i = 0;
        for (Sim sim : sims) {
            if (sim.cir.equals(cir1)) {
                sim.cir = cir2;
                val[i] = sim;
                i++;
            }
        }
        for (int k = 0; k < val.length - 1; k++) {
            for (int j = k + 1; j < val.length; j++) {
                if (val[k].rps < val[j].rps) {
                    Sim temp = val[k];
                    val[k] = val[j];
                    val[j] = temp;
                }
            }
        }
        return val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim[] obj = new Sim[5];
        for (int i = 0; i < obj.length; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String cn = sc.nextLine();
            double bal = sc.nextDouble();
            sc.nextLine();
            double rps = sc.nextDouble();
            sc.nextLine();
            String cir = sc.nextLine();

            obj[i] = new Sim(id, cn, bal, rps, cir);
        }

        String cir1 = sc.nextLine();
        String cir2 = sc.nextLine();
        Sim[] result = transferCusCir(obj, cir1, cir2);

        for (Sim sim : result) {
            System.out.println(sim.id + " " + sim.cn + " " + sim.cir + " " + sim.rps);
        }
    }
}

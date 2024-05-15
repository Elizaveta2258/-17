import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try(ObjectOutputStream outp = new ObjectOutputStream(new FileOutputStream("D://text.txt"));
            ObjectInputStream inp = new ObjectInputStream((new FileInputStream("D://text.txt")))){
            Scanner input = new Scanner(System.in);
            boolean check = true;
            System.out.println("Введите число");
            Double x = input.nextDouble();
            while (check) {
                System.out.println("Введите команду");
                String in = input.next();
                Solver solver = new Solver(x);
                if (in.equals("save")) {
                    outp.writeObject(solver);
                    System.out.println("Сохранено");
                    check = true;
                }
                if (in.equals("upload")) {
                    Solver object = (Solver) inp.readObject();
                    double y = object.x;
                    double z = object.solve();
                    System.out.println(y);
                    System.out.println(z);
                    check = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
class Solver implements Serializable
{
    double x;
    Solver(double x){
        this.x = x;
    }
    public double solve() {
        double y = x - Math.sin(x);
        return y;
    }

}

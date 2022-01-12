import java.util.ArrayList;
import java.util.Scanner;

public class app {
    public static void main(String[] args){

        while (true){
            int selection;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the size of the problem: ");
            int size = scanner.nextInt();

            System.out.print("[1]Hill Climbing\n[2]Min Conflict\n[3]Exit\n");
            selection = scanner.nextInt();

            switch (selection){
                case 1:
                    HillClimbing hc = new HillClimbing(size);
                    System.out.println("Hill Climbing");
                    hc.randomlyRestart();
                    break;
                case 2:
                    System.out.println("Min Conflict");
                    System.out.println("Please enter the max step: ");
                    int max = scanner.nextInt();

                    MinConflict mc = new MinConflict(size,max);
                    if(!mc.solve()){
                        System.out.println("The search fail");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

        /**
        HillClimbing hc = new HillClimbing(8);
        System.out.println("Hill Climbing");
        for(int j = 0 ; j < 50; j++){
            long startTime = System.nanoTime();
            hc.randomlyRestart();
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.print((double) totalTime / 1000000000 + "\n");
            System.out.println("The total time consuming: " + (double) totalTime / 1000000000 + "s");
            System.out.print("\n\n\n");
        }


        System.out.println("Min Conflict");
        MinConflict mc = new MinConflict(8, 60);
        for(int i = 0; i < 100; i++){
            long startTime1 = System.nanoTime();
            if(!mc.solve()){
                System.out.println("The search fail");
            }
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime1;
            System.out.println("The total time consuming: " + totalTime + "ns");
            System.out.print("\n\n\n");
        }
         */

    }
}

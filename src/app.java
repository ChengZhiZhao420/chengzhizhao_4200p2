import java.util.ArrayList;

public class app {
    public static void main(String[] args){

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

    }
}

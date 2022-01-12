import java.util.ArrayList;
import java.util.Random;

public class MinConflict {
    private int size;
    private int maxStep;

    public MinConflict(int size, int maxStep){
        this.size = size;
        this.maxStep = maxStep;
    }

    /**
     * getting the complete result of none of the queen are attacking
     * @return true if the result has no queen attacking each other
     */
    public boolean solve(){
        Queen queen = new Queen();
        int[][] current = queen.randomQueen(size);
        System.out.println("The initial state is: ");
        queen.printPuzzle(current);

        for(int i = 0; i < maxStep; i++){
            int h = queen.getHeuristic(current);

            //if current state has no queen attacking each other, then print the current state and return true
            if(h == 0){
                System.out.println("The total cost: " + i);
                System.out.println("The Final result: ");
                queen.printPuzzle(current);
                return true;
            }
            else{
                int conflictPosition = getRandomConflictPosition(current, queen); // randomly select the conflicting queen
                ArrayList<int[]> successors = queen.generateSuccessor(current, conflictPosition); // generate possible successor base on this queen
                current = queen.getNeighbor(successors);
            }
        }
        return false;
    }

    /**
     * Get conflict position randomly
     * @param puzzle current state
     * @param queen
     * @return conflict position
     */
    public int getRandomConflictPosition(int[][] puzzle, Queen queen){
        int[] queenPosition = queen.getQueenPosition(puzzle);
        ArrayList<Integer> listOfConflict = queen.getConflict(queenPosition);

        return listOfConflict.get(new Random().nextInt(0, listOfConflict.size()));
    }
}

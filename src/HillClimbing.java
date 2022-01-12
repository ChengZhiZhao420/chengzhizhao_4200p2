import java.util.ArrayList;

public class HillClimbing {
    private int size;

    public HillClimbing(int size){
        this.size = size;
    }

    public void randomlyRestart(){
        Queen queen = new Queen();
        int[][] current = queen.randomQueen(size);
        int cost = 0;

        System.out.println("The initial state is: ");
        queen.printPuzzle(current);

        while(true){
            int[][] solution = solve(current);
            if(queen.getHeuristic(solution) == 0){
                System.out.println("The total cost: " + cost);
                System.out.println("The Heuristic value of the current state is: " + queen.getHeuristic(solution));
                System.out.print("Final State is: \n");
                queen.printPuzzle(solution);
                break;
            }
            current = queen.randomQueen(size);
            cost++;
        }
    }

    /**
     * solve the problem
     */
    public int[][] solve(int[][] currentState){
        Queen queen = new Queen();
        int cost = 0;
        int[][] result = null;
        boolean found = false;

        while(!found){
            ArrayList<int[]> possibleSuccessor = queen.generateSuccessor(currentState); //generate all the possible successors
            int[][] nextState = queen.getNeighbor(possibleSuccessor); // get the best neighbor from all the possible successors
            int h1 = queen.getHeuristic(currentState);
            int h2 = queen.getHeuristic(nextState);

            if(h2 < h1){ // compare the heuristic value of the current state and neighbor state
                currentState = nextState;
                cost++;
            }
            else { // if they are equal then return the current state
                result = currentState;
                found = true;
            }
        }
        return result;
    }

}

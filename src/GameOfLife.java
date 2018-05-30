import java.util.ArrayList;
import java.util.Collection;

public class GameOfLife
{
    public static void main(String[] args)
    {
    	String[][] initialGrid=readInput();
    	printInitialGrid(initialGrid);
    	String[][] generatedGrid=generateGrid(initialGrid);
    	printGeneratedGrid(generatedGrid);
    }
    private static String[][] generateGrid(String[][] initialGrid) {
    	int rows = initialGrid.length; int columns = initialGrid[0].length;
    	String[][] newGrid = new String[rows][columns];
    	for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                Collection<String> neighbours = getNeighbours(initialGrid,i,j);
                if(giveLife(initialGrid[i][j],neighbours))
                	newGrid[i][j]="O";
                else
                	newGrid[i][j]=".";
            }
            System.out.println();
        }
		return newGrid;
	}
	private static boolean giveLife(String string, Collection<String> neighbours) {
		boolean giveLife=false;
		int counter=0;
		for(String element: neighbours)
			if(element.equals("O"))
				counter++;
		if(string.equals("O")&&(counter==2||counter==3))
			giveLife=true;
		if(string.equals(".")&&(counter==3))
			giveLife=true;
		
		return giveLife;
	}
	private static Collection<String> getNeighbours(String[][] initialGrid, int i, int j) {
		int rows = initialGrid.length; int columns = initialGrid[0].length;
		//System.out.println("rows "+rows+" columns "+columns);
		ArrayList<String> neighbours = new ArrayList<>();
		if(i-1>=0&&j-1>=0)
			neighbours.add(initialGrid[i-1][j-1]);
		if(i-1>=0)
			neighbours.add(initialGrid[i-1][j]);
		if(i-1>=0&&j+1<columns)
			neighbours.add(initialGrid[i-1][j+1]);
		if(j+1<columns) {
			neighbours.add(initialGrid[i][j+1]);
		}
		if(i+1<rows&&j+1<columns) {
			//System.out.println("i "+i+" j+1 "+j+1);
			neighbours.add(initialGrid[i+1][j+1]);
		}
		if(i+1<rows)
			neighbours.add(initialGrid[i+1][j]);
		if(i+1<rows&&j-1>=0)
			neighbours.add(initialGrid[i+1][j-1]);
		if(j-1>=0)
			neighbours.add(initialGrid[i][j-1]);
		return neighbours;
	}
	
	private static void printInitialGrid(String[][] initialGrid) {
    	System.out.println("Initial Generation");
        printGrid(initialGrid);
		
	}
	
	private static void printGeneratedGrid(String[][] generatedGrid) {
    	System.out.println("Calculated Generation");
        printGrid(generatedGrid);
		
	}
	
	private static void printGrid(String[][] initialGrid) {
		for (int i = 0; i < initialGrid.length; i++)
        {
            for (int j = 0; j < initialGrid[0].length; j++)
            {
                System.out.print(initialGrid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        /*System.out.println("Grid positions");
        for (int i = 0; i < initialGrid.length; i++)
        {
            for (int j = 0; j < initialGrid[0].length; j++)
            {
                System.out.print(" i:"+i+" j:"+j);
            }
            System.out.println();
        }
        System.out.println();	*/
	}
	
	static String[][] initializeGrid() {
   	 
        String[][] grid = { 
        		{ ".", ".", ".", ".", ".", ".", "O", "." },
        		{ "O", "O", "O", ".", ".", ".", "O", "." },
        		{ ".", ".", ".", ".", ".", ".", "O", "." },
        		{ ".", ".", ".", ".", ".", ".", ".", "." },
        		{ ".", "O", "O", ".", ".", ".", ".", "." },
        		{ ".", "O", "O", ".", ".", ".", ".", "." },
        };
 
        return grid;
    }
    static String[][] readInput(){
    	/*This function can take input from command line instead of function*/
    	return initializeGrid();
    }
}
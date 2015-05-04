package myGame;

import java.util.Scanner;

public class MyGame {

	
	public static void main(String[] ar){
		Scanner in= new Scanner(System.in);
		
		System.out.print("Enter the pattern: ");
		String gridMap= in.next();
		String[] entriesInARow=gridMap.split(",");
		
		MyGame myGame= new MyGame();
		Object [][] gridLayOut=myGame.createMyGame(entriesInARow);
		
		PlayGame playGame= new PlayGame(gridLayOut);
		playGame.printBoard();
		playGame.startGame();
		
	}
	
	Object[][] createMyGame(String[] gridMap){
		int lengthOfGrid=gridMap.length;
		Object[][] gridLayOut= new Object[lengthOfGrid][lengthOfGrid];
		for(int row=0;row<lengthOfGrid;row++){
			String word=gridMap[row];
			for(int column=0;column<lengthOfGrid;column++){
				Cell cell= new Cell();
				cell.setName('x');
				char alphabet=word.charAt(column);
				if(alphabet=='x'){
					cell.setMine(false);
					gridLayOut[row][column]=cell;	
				}else if(alphabet=='m'){
					cell.setMine(true);
					gridLayOut[row][column]=cell;	
				}
			}
		}
		return gridLayOut;
	}
	
}

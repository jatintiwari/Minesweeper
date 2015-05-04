package myGame;

import java.util.Scanner;

public class PlayGame {

	Object[][] gridLayOut;
	int gridSize;
	int inValidFlags;
	int turns;
	
	PlayGame(Object[][] gridLayOut){
		this.gridLayOut=gridLayOut;
	}

	public void printBoard() {
		int rowSize=gridLayOut.length;
		this.gridSize=rowSize*rowSize;
		for(int row=0;row<rowSize;row++){
			for(int col=0;col<rowSize;col++){
				Cell cell=(Cell)this.gridLayOut[row][col];
				System.out.print(cell.getName());
			}
			System.out.println();
		}

	}


	void startGame(){
		Scanner in= new Scanner(System.in);
		boolean gameIsOn=true;
		try{
			do{
				if(!gameIsOn){
					
				}
				System.out.print("Enter line no: ");
				int line=in.nextInt();
				System.out.print("Enter column no: ");
				int column=in.nextInt();

				System.out.print("Enter Choice: Open(o)/Flag(f): ");
				String choice=in.next();

				Cell cell=(Cell)this.gridLayOut[line][column];
				if(turns<9){
					if(choice.equalsIgnoreCase("o")){
						if(cell.isOpen()){
							System.out.println("Cell Already visited, Please try another");
						}else if(cell.isMine()){
							cell.setName('m');
							System.out.println("Oops you stepped on mine, Game finished!!");
							cell.setOpen(true);
							gameIsOn=false;
							turns++;
						}else if(cell.isMine()==false && cell.isOpen()==false) {
							cell.setOpen(true);
							cell.setName('0');
							turns++;
						}else if(cell.isOpen()){
							System.out.println("Cell Already visited, Please try another");
						}
					}else if(choice.equalsIgnoreCase("f")){
						if(cell.isOpen()){
							System.out.println("Cell Already visited, Please try another");
						}else if(cell.isMine() && cell.isOpen()==false){
							cell.setFlag(true);
							cell.setOpen(true);
							cell.setName('f');
							turns++;
						}else if(cell.isMine()==false && cell.isOpen()==false){
							cell.setFlag(true);
							cell.setOpen(true);
							cell.setName('f');
							turns++;
							this.inValidFlags++;
						}
					}
				}else if(turns>8 && inValidFlags>0){
					System.out.println("Game finished!!  No. of invalid flags: "+this.inValidFlags);
					gameIsOn=false;
				}if(turns>8 && inValidFlags==0){
					System.out.println("Game finished!!  You won!!! ");
					gameIsOn=false;
				}
				printBoard();
			}while(gameIsOn);
		}catch(Exception e){
				e.printStackTrace();
		}

	}

}

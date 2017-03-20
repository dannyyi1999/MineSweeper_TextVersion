/*
 * Danny Yi March 16th 2017 Period 4
 * This lab took me approximately 180 minutes.
 * This was definitely a pretty time consuming lab that I probably should not have procrastinated
 * but I think I ended up getting everything that I needed to get. It wasn't as easy as I thought it
 * would be, but it was definitely understandable because of my past experience with the life game
 * which actually was really useful in helping me understand and be more efficient with creating this
 * text based minesweeper game. I had some fun coding this game and it definitely felt like an accomplishment.
 * I am looking forward to creating a GUI version of this game soon!
 */

import java.util.Scanner;


public class P4_Yi_Danny_MinesweeperController {
	
	public static void main(String[] args) {
		
		boolean revealBoard = true;
		
		Scanner in = new Scanner(System.in);
		P4_Yi_Danny_MinesweeperModel model = new P4_Yi_Danny_MinesweeperModel(2, 2, 3);
		model.setGrid(model.getNumRows(), model.getNumCols(), model.getNumMines());
		System.out.println("Welcome to Minesweeper!");
		model.printBoard();
		if(revealBoard){
			model.printStackedBoard();
		}
		
		
		while(!model.isGameOver()){
			System.out.println("Press r to reveal; press f to flag");
			String choice = in.next();
			if(choice.equals("r")){
				System.out.println("Choose a point");
				model.reveal(in.nextInt(), in.nextInt());
			}else if(choice.equals("f")){
				System.out.println("Choose a point");
				model.setFlag(in.nextInt(), in.nextInt());
			}else {
				System.out.println("Sorry that is invalid");
			}
			model.printBoard();
			if(revealBoard){
				model.printStackedBoard();
			}
			System.out.println("There are " + model.getNumMines() + " left.");
		}
		
		if(model.getNumRevealed() + model.getNumFlags() + model.getNumMines() == model.getNumRows() * model.getNumCols()){
			System.out.println("CONGRATS! YOU WIN!!!!");
		}else {
			System.out.println("Oh No! You Lose!");
		}
	}

}

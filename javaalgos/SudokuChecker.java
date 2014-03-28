/*
 * sudokuChecker.java	Created on 3 okt. 2013
 * 
 */

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuChecker {	
	
	public boolean checkSudoku(Integer[][] input){
		// Check the rowcount
		if (input.length != 9){
			System.out.println("Rowcount failed was "+input.length);
			return false;
		}
		Map<Point,Set<Integer>> regionsMap = createContainerMap();
		Map<Integer,Set<Integer>> columnMap = createXorYMap();
		Map<Integer,Set<Integer>> rowMap = createXorYMap();
		Set<Integer> regionSet = null;
		Set<Integer> columnSet = null;
		Set<Integer> rowSet = null;
		
		for (int row = 0; row < input.length; row++) {
			Integer[] numbers = input[row];
			if(numbers.length != 9){
				System.out.println("column count failed was "+numbers.length);
				return false;
			}
			for (int column = 0; column < numbers.length; column++) {
				Integer numberToCheck = numbers[column];
				if(numberToCheck > 0 && numberToCheck <= 9){
					// Get the row, column and region set
					rowSet = rowMap.get(row);
					columnSet = columnMap.get(column);
					Point position = new Point(row - (row%3), column - (column%3));
					regionSet = regionsMap.get(position);
					// try to add the number to the sets
					if (!(rowSet.add(numberToCheck) &&
						  columnSet.add(numberToCheck) &&
						  regionSet.add(numberToCheck))){
						System.out.println("Wrong number at row: "+(row+1)+" col: "+(column+1));
						return false;
					}
				} else {
					System.out.println("wrong number");
					return false; // numberToCheck not allowed so not correct by definition 
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @return a map containing all the regions
	 */
	private Map<Point,Set<Integer>> createContainerMap(){
		Map<Point,Set<Integer>> map = new HashMap<Point,Set<Integer>>();
		map.put(new Point(0,0),new HashSet<Integer>());
		map.put(new Point(0,3),new HashSet<Integer>());
		map.put(new Point(0,6),new HashSet<Integer>());
		map.put(new Point(3,0),new HashSet<Integer>());
		map.put(new Point(3,3),new HashSet<Integer>());
		map.put(new Point(3,6),new HashSet<Integer>());
		map.put(new Point(6,0),new HashSet<Integer>());
		map.put(new Point(6,3),new HashSet<Integer>());
		map.put(new Point(6,6),new HashSet<Integer>());
		return map;
	}
	
	private Map<Integer,Set<Integer>> createXorYMap(){
		Map<Integer,Set<Integer>> columnMap = new HashMap<Integer,Set<Integer>>();
		for(Integer i = 0; i < 9; i++){
			columnMap.put(i,new HashSet<Integer>());
		}
		return columnMap;
	}
	
	// test a wrong and good Sudoku
	public static void main(String[] args){
		SudokuChecker checker = new SudokuChecker();
		System.out.println("started");
		Integer [][] inputWithNotCorrectData = {{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9}};
		System.out.println("with not correct data check is: "+checker.checkSudoku(inputWithNotCorrectData));
		Integer [][] inputWithCorrectData = {{1,2,3,4,5,6,7,9,8},
											 {4,5,6,7,8,9,1,2,3},
											 {7,8,9,2,3,1,4,5,6},
											 {2,1,4,5,6,8,9,3,7},
											 {3,6,5,9,2,7,8,1,4},
											 {8,9,7,1,4,3,2,6,5},
											 {5,7,2,3,9,4,6,8,1},
											 {9,4,8,6,1,5,3,7,2},
											 {6,3,1,8,7,2,5,4,9}};
      System.out.println("with correct data check is: "+checker.checkSudoku(inputWithCorrectData));
	}
	

}

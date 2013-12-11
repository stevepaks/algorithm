package Greedy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinTest {
	
	public static void main(String[] args){
		Min engine = null;
		
		Scanner in;
		try {
			in = new Scanner(new File("Input.txt"));
			engine = new Min(in.nextInt());
			for(int i = 0 ; i < engine.getNoOfWeight() ; i++){
				engine.addWeight(in.nextInt());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		engine.setMax();
		
		engine.sort();
		
		System.out.println(engine.getMin());
		
	}

}

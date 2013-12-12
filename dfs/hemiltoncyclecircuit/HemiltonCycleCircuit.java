package dfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HemiltonCycleCircuit {
	private int[] route;
	private int depth;
	private int noOfSite;
	private int noOfRoute;
	private int minCircuit;
	private int maxCircuit;
	private int[][] circuitBoard;

	public HemiltonCycleCircuit(int noOfSite) {
		this.route = new int[noOfSite];
		this.circuitBoard = new int[noOfSite][noOfSite];
		for (int i = 0; i < this.route.length; i++) {
			this.route[i] = Integer.MAX_VALUE;
		}
		this.depth = 0;
		this.noOfRoute = 0;
		this.minCircuit = 0;
		this.maxCircuit = 0;
		this.noOfSite = noOfSite;
		this.push(0);
	}

	public void registerCircuit(Scanner in) {
		for (int i = 0; i < this.noOfSite; i++) {
			for (int j = 0; j < this.noOfSite; j++) {
				this.circuitBoard[i][j] = in.nextInt();
			}
		}
	}

	private void push(int site) {
		this.route[this.depth++] = site;
	}

	private void pop() {
		this.route[--this.depth] = Integer.MAX_VALUE;
	}

	private boolean containsSite(int site) {
		for (int route : this.route) {
			if (route == site) {
				return true;
			}
		}
		return false;
	}

	public void makeAvailableCircuit() {
		if (this.depth == this.noOfSite) {
			this.printCircuit();
			this.findMinCircuit();
			this.findMaxCircuit();
			this.noOfRoute++;
			return;
		}

		for (int site = 1; site < this.noOfSite; site++) {
			if (!this.containsSite(site)) {
				this.push(site);
				this.makeAvailableCircuit();
				this.pop();
			}
		}
	}
	
	private void findMinCircuit(){
		int tempCircuit = 0;
		int i = 1;
		for(; i < this.noOfSite ; i++){
			tempCircuit += this.circuitBoard[this.route[i-1]][this.route[i]];
		}
		tempCircuit += this.circuitBoard[this.route[i-1]][0];
		if(this.minCircuit == 0 || tempCircuit < this.minCircuit){
			this.minCircuit = tempCircuit;
		}
	}
	
	private void findMaxCircuit(){
		int tempCircuit = 0;
		int i = 1;
		for(; i < this.noOfSite ; i++){
			tempCircuit += this.circuitBoard[this.route[i-1]][this.route[i]];
		}
		tempCircuit += this.circuitBoard[this.route[i-1]][0];
		if(this.maxCircuit == 0 || tempCircuit > this.maxCircuit){
			this.maxCircuit = tempCircuit;
		}
	}

	private void printCircuit() {
		for (int r : this.route) {
			System.out.print(r + " ");
		}
		System.out.println();
	}
	
	public void printCircuitInfo(){
		System.out.println(this.noOfRoute);
		System.out.println(this.minCircuit);
		System.out.println(this.maxCircuit);
	}

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HemiltonCycleCircuit hemiltonCycleCircuit = new HemiltonCycleCircuit(
				in.nextInt());
		
		hemiltonCycleCircuit.registerCircuit(in);
		
		hemiltonCycleCircuit.makeAvailableCircuit();
		
		hemiltonCycleCircuit.printCircuitInfo();
	}
}

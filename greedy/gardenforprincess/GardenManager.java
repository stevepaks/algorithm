package gardenforprincess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GardenManager {
	private List<Flower> allFlowers;
	public final Duration horizon = new Duration(3, 1, 11, 30);
	private Scanner in;
	
	public GardenManager() throws IOException{
		this.init();
		this.makeFlowerList();
		this.sortFlowers();
		this.setFirstFlower();
	}
	
	private void init() throws IOException{
		in = new Scanner(new File("input.txt"));		
		this.allFlowers = Collections.synchronizedList(new ArrayList<Flower>());
	}
	
	private void makeFlowerList(){
		int noOfFlowers = this.in.nextInt();
		for(int i = 0 ; i < noOfFlowers ; i++){
			this.addFlower(new Flower(i, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
		}			
	}
	
	private void sortFlowers(){
		Collections.sort(allFlowers, new FlowerComparator());
	}
	
	private void addFlower(Flower flower){
		this.allFlowers.add(flower);
	}
	
	public List<Flower> getFlowerList(){
		return this.allFlowers;
	}
	
	public Duration getHorizon(){
		return this.horizon;
	}
	
	public Flower getFirstFlower(){
		Flower firstFlower = null;
		for(Flower flower : this.allFlowers){
			if(flower.isFirst()){
				if(firstFlower == null || firstFlower.getFallingDay().getTime() < flower.getFallingDay().getTime()){
					firstFlower = flower;
				}
			}
		}
		return firstFlower;
	}
	
	private void setFirstFlower(){
		for(Flower flower : allFlowers){
			if(horizon.getBeginDay().after(flower.getBloomingDay())){
				flower.setToFirst();
			}
		}
	}
	
	class FlowerComparator implements Comparator<Flower>{

		@Override
		public int compare(Flower flower1, Flower flower2) {
			// TODO Auto-generated method stub
			if(flower1.getBloomingDay().getTime() > flower2.getBloomingDay().getTime()){
				return 1;
			}
			if(flower1.getBloomingDay().getTime() == flower2.getBloomingDay().getTime()){
				if(flower1.getBloomingPeriod().getDurationTime() > flower2.getBloomingPeriod().getDurationTime()){
					return 1;
				}else{
					return -1;
				}
			}else{
				return -1;
			}
		}
		
	}
	
}

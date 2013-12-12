package gardenforprincess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FlowerProviderChainGenerator {
	
	private GardenManager gardenManager;
	private List<Flower> flowerProviderChain;
	
	public FlowerProviderChainGenerator(GardenManager gardenManager){
		this.init();
		this.gardenManager = gardenManager;
		this.makeProviderChain();
	}
	
	private void makeProviderChain(){
		Flower flower = this.gardenManager.getFirstFlower();
		while(flower.getFallingDay().getTime() < this.gardenManager.getHorizon().getEndDay().getTime()){
			this.flowerProviderChain.add(flower);
			flower = this.getNextFlower(flower);			
		}
		this.flowerProviderChain.add(flower);
	}
	
	private Flower getNextFlower(Flower flower){
		return this.getMaxFallingDayFlower(this.getCandidates(flower));
	}
	
	 private List<Flower> getCandidates(Flower flower){
		List<Flower> candidates = Collections.synchronizedList(new ArrayList<Flower>());
		for(Flower localFlower : this.gardenManager.getFlowerList()){
			if(localFlower.isFirst()){
				continue;
			}
			if(flower.contains(localFlower)){
				candidates.add(localFlower);
			}
		}
		return candidates;
	}
	
	private Flower getMaxFallingDayFlower(List<Flower> candidates){
		Flower maxFallingDayFlower = null;
		for(Flower candidate : candidates){				
			if(maxFallingDayFlower == null || candidate.getFallingDay().getTime() > maxFallingDayFlower.getFallingDay().getTime()){
				maxFallingDayFlower = candidate;					
			}			
		}
		return (Flower)maxFallingDayFlower;
	}
	
	private void init(){
		this.flowerProviderChain = Collections.synchronizedList(new ArrayList<Flower>());
	}
	
	public List<Flower> getFlowerProviderChain(){
		return this.flowerProviderChain;
	}
}

package gardenforprincess;

import java.io.IOException;
import java.sql.SQLException;


public class GardenForPrincessTest {
	public static void main(String[] args) throws InterruptedException, SQLException{
		
		GardenManager gardenManager = new GardenManager();
		
		//loading flower list
		for(Flower flower : gardenManager.getFlowerList()){
			System.out.println(flower.toString());
		}
		
		System.out.println();
		
		//flower provider chain generation
		FlowerProviderChainGenerator flowerProviderChain = new FlowerProviderChainGenerator(gardenManager);
		
		System.out.println();
		for(Flower flower : flowerProviderChain.getFlowerProviderChain()){
			System.out.println(flower.toString());
		}
		
		System.exit(0);
	}

}

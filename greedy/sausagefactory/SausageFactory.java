package sausageFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SausageFactory {
	ArrayList<Sausage> sausages;
	ArrayList<Comparator<Sausage>> comparatorList;
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
//		PrintWriter out = new PrintWriter(new File("output.txt"));
//		int leadTime = 1;
//		int preLength = 0, preWidth = 0;
		int noOfSausage = in.nextInt();
		SausageFactory sFactory = new SausageFactory(noOfSausage);
		int lenth = 0, width = 0;
		
		for(int i = 0 ; i < noOfSausage ; i++){
			lenth = in.nextInt();
			width = in.nextInt();
			sFactory.addSausages(lenth, width);			
		}
		
		System.out.println("--------Input---------");
		
		sFactory.printSausages();
		
		System.out.println("--------Output---------");

		sFactory.sortSausages();
		
		sFactory.printSausages();
	}
	
	public void printSausages(){
		for(Sausage sausage : this.getSausages()){
			System.out.print(sausage.getLenth());
			System.out.print(sausage.getWidth());
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public void insert(int i, int j){
		Sausage tempSausage = this.sausages.get(j);
		sausages.remove(j);		
		this.sausages.add(i+1, tempSausage);
	}
	
	public ArrayList<Sausage> getSausages(){
		return this.sausages;
	}
	
	public SausageFactory(int noOfSausage){
		sausages = new ArrayList<Sausage>();
		comparatorList = new ArrayList<Comparator<Sausage>>();
		comparatorList.add(new SausageComparator());	//length를 비교
		comparatorList.add(new SausageComparator2());	//length와 width를 비교
	}
	
	public void sortSausages(){
		for(Comparator<Sausage> comparator : this.comparatorList){
			Collections.sort(this.sausages, comparator);
		}
		
		printSausages();
		
		for(int i = 0 ; i < sausages.size()-1 ; i++){
			if(sausages.get(i).getLenth() > sausages.get(i+1).getLenth() ||
					sausages.get(i).getWidth() > sausages.get(i+1).getWidth()){	//연속된 숫자쌍 중 pre의 두 숫자가 모두 크면
				for(int j = i+1 ; j < this.getSausages().size() ; j++){	//pre와 나머지 숫자쌍을 비교
					if(sausages.get(i).getLenth() <= sausages.get(j).getLenth() &&
							sausages.get(i).getWidth() <= sausages.get(j).getWidth()){	//나머지 숫자쌍 중 pre보다 큰 것이 있으면
						this.insert(i, j);	//해당 숫자쌍을 pre의 다음 위치로 insert
						i = 0;
						break;
					}
				}
			}
		}
	}
	
	public void addSausages(int lenth, int width){
		this.sausages.add(new Sausage(lenth, width));
	}
	
	public class SausageComparator implements Comparator<Sausage>{

		@Override
		public int compare(Sausage pre, Sausage post) {
			// TODO Auto-generated method stub
			if(pre.getLenth() >= post.getLenth()){
				return 1;
			}else{
				return -1;
			}
		}
		
	}
	
	public class SausageComparator2 implements Comparator<Sausage>{

		@Override
		public int compare(Sausage pre, Sausage post) {
			// TODO Auto-generated method stub
			if(pre.getWidth() >= post.getWidth() && pre.getLenth() >= post.getLenth()){
				return 1;
			}else{
				return -1;
			}
		}
		
	}
}

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
		comparatorList.add(new SausageComparator());	//length�� ��
		comparatorList.add(new SausageComparator2());	//length�� width�� ��
	}
	
	public void sortSausages(){
		for(Comparator<Sausage> comparator : this.comparatorList){
			Collections.sort(this.sausages, comparator);
		}
		
		printSausages();
		
		for(int i = 0 ; i < sausages.size()-1 ; i++){
			if(sausages.get(i).getLenth() > sausages.get(i+1).getLenth() ||
					sausages.get(i).getWidth() > sausages.get(i+1).getWidth()){	//���ӵ� ���ڽ� �� pre�� �� ���ڰ� ��� ũ��
				for(int j = i+1 ; j < this.getSausages().size() ; j++){	//pre�� ������ ���ڽ��� ��
					if(sausages.get(i).getLenth() <= sausages.get(j).getLenth() &&
							sausages.get(i).getWidth() <= sausages.get(j).getWidth()){	//������ ���ڽ� �� pre���� ū ���� ������
						this.insert(i, j);	//�ش� ���ڽ��� pre�� ���� ��ġ�� insert
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

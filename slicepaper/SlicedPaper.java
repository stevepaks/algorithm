package slicedPaper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SlicedPaper extends Paper{
	
	public SlicedPaper(int widthStartPoint, int widthEndPoint,
			int heightStartPoint, int heightEndPoint) {
		super(widthStartPoint, widthEndPoint, heightStartPoint, heightEndPoint);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void sortMyPaper(ArrayList<Paper> paperList){
		Collections.sort(paperList, new PaperComparator());
	}
	
	public boolean myContains(int isWidth, int point){
		//가로 ture, 세로 false 
		if(isWidth == 1){
			if(this.getWidthStartPoint() < point && this.getWidthEndPoint() > point){
				return true;
			}
		}else{
			if(this.getHeightStartPoint() < point && this.getHeightEndPoint() > point){
				return true;
			}
		}
		return false;
	}
	
	public class PaperComparator implements Comparator<Paper>{

		@Override
		public int compare(Paper p1, Paper p2) {
			// TODO Auto-generated method stub
			if(p1.getArea() < p2.getArea()){
				return 1;
			}
			return -1;
		}
		
	}

}

package slicedPaper;

import java.util.ArrayList;

public abstract class Paper {
	private int widthStartPoint;
	private int widthEndPoint;
	private int heightStartPoint;
	private int heightEndPoint;
	
	public boolean contains(int axis, int point){
		return myContains(axis, point);
	}
	
	public void sortPaper(ArrayList<Paper> paperList){
		this.sortMyPaper(paperList);
	}
	
	public abstract boolean myContains(int axis, int point);
	public abstract void sortMyPaper(ArrayList<Paper> paperList);
	
	
	public Paper(int widthStartPoint, int widthEndPoint, int heightStartPoint, int heightEndPoint){
		this.widthStartPoint = widthStartPoint;
		this.widthEndPoint = widthEndPoint;
		this.heightStartPoint = heightStartPoint;
		this.heightEndPoint = heightEndPoint;
	}
	
	public int getWidthStartPoint(){
		return this.widthStartPoint;
	}
	
	public int getWidthEndPoint(){
		return this.widthEndPoint;
	}
	
	public int getHeightStartPoint(){
		return this.heightStartPoint;
	}
	
	public int getHeightEndPoint(){
		return this.heightEndPoint;
	}
	
	public int getArea(){
		int width = this.widthEndPoint - this.widthStartPoint;
		int height = this.heightEndPoint - this.heightStartPoint;
		return width * height;
	}
}

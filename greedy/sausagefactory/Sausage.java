package sausageFactory;

public class Sausage implements Cloneable{
	private int sl, sw;
	
	public Sausage(int sl, int sw){
		this.sl = sl;
		this.sw = sw;
	}
	
	public int getWidth(){
		return sw;
	}
	
	public int getLenth(){
		return sl;
	}
	
	public void setWidth(int sw){
		this.sw = sw;
	}
	
	public void setLenth(int sl){
		this.sl = sl;
	}
	
	public String toString(){
		return sl + " " + sw;		
	}
}
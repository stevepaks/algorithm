package slicedPaper;

public interface PaperStore {	
	public void createPaper(int widthStartPoint, int widthEndPoint, int heightStartPoint, int heightEndPoint);	
	public PaperFactory getPaperFactory();	
	public Paper getPaper(); 

}

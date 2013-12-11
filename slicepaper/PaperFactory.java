package slicedPaper;

import java.util.ArrayList;

public interface PaperFactory {
	public Paper createPaper(int widthStartPoint, int widthEndPoint, int heightStartPoint, int heightEndPoint);	
	public ArrayList<Paper> slicePaper(int isWidth, int point, ArrayList<Paper> slicedPapers);

}

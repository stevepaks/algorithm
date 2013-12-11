package slicedPaper;

import java.util.ArrayList;

public class SlicedPaperFactory implements PaperFactory{

	@Override
	public Paper createPaper(int widthStartPoint, int widthEndPoint,
			int heightStartPoint, int heightEndPoint) {
		return new SlicedPaper(widthStartPoint, widthEndPoint, heightStartPoint, heightEndPoint);
	}

	@Override
	public ArrayList<Paper> slicePaper(int isWidth, int point,
			ArrayList<Paper> slicedPapers) {
		ArrayList<Paper> resultOfSlice = new ArrayList<Paper>();
		for(Paper paper : slicedPapers){
			int widthStartPoint = paper.getWidthStartPoint();
			int widthEndPoint = paper.getWidthEndPoint();
			int heightStartPoint = paper.getHeightStartPoint();
			int heightEndPoint = paper.getHeightEndPoint();
			
			if(isWidth == 1 && paper.contains(isWidth, point)){
				//isWidth가 1이면
				resultOfSlice.add(createPaper(widthStartPoint, point, heightStartPoint, heightEndPoint));
				resultOfSlice.add(createPaper(point, widthEndPoint, heightStartPoint, heightEndPoint));
				continue;
			}else if(isWidth == 0 && paper.contains(isWidth, point)){
				//isWidth가 0이면
				resultOfSlice.add(createPaper(widthStartPoint, widthEndPoint, heightStartPoint, point));
				resultOfSlice.add(createPaper(widthStartPoint, widthEndPoint, point, heightEndPoint));
				continue;
			}
			resultOfSlice.add(paper);
		}
		return resultOfSlice;
	}
	
}

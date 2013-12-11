package slicedPaper;

public class SlicedPaperStore implements PaperStore {
	
	private PaperFactory slicedPaperFactory;
	private Paper slicedPaper;
	
	public SlicedPaperStore(){
		slicedPaperFactory = new SlicedPaperFactory(); 
	}

	@Override
	public void createPaper(int widthStartPoint, int widthEndPoint,
			int heightStartPoint, int heightEndPoint) {
		this.slicedPaper =  this.slicedPaperFactory.createPaper(widthStartPoint, widthEndPoint, heightStartPoint, heightEndPoint);		
	}

	@Override
	public PaperFactory getPaperFactory() {
		return this.slicedPaperFactory;
	}

	@Override
	public Paper getPaper() {
		return this.slicedPaper;
	}

}

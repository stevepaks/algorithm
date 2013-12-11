package slicedPaper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PaperStoreTest {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		int widthEndPoint = in.nextInt();
		int heightEndPoint = in.nextInt();
		
		ArrayList<Paper> papers = new ArrayList<Paper>();
		
		PaperStore slicedPaperStore = new SlicedPaperStore();		
		PaperFactory slicedPaperFactory = slicedPaperStore.getPaperFactory();		
		Paper paper = slicedPaperFactory.createPaper(0, widthEndPoint, 0, heightEndPoint);
		
		papers.add(paper);
		int count = in.nextInt();
		for(int i = 0 ; i < count ; i++){
			papers = slicedPaperFactory.slicePaper(in.nextInt(), in.nextInt(), papers);
		}
		
		paper.sortPaper(papers);
		
		for(Paper entry : papers){
			System.out.println(entry.getArea());
		}
	}

}

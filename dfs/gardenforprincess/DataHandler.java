package gardenforprincess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
	private final String GET_FLOWER_COUNT = "select count(*) from flower";
	private final String GET_FLOWER = "select * from flower";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private final int PERIOD_INDICATOR = 4;
	private int count = 0;
	
	public DataHandler() throws SQLException{
		conn = Jdbchandler.JdbcHandler.getConnetion();
				
		if(conn == null){
			System.out.println("연결 실패");
			System.exit(0);
		}
		System.out.println("연결 성공");
		
		conn.getAutoCommit();
	}
	
	public List<int[]> getPeriodList(){
		List<int[]> periodList = new ArrayList<int[]>();
		try {
			pstmt = conn.prepareStatement(GET_FLOWER);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				int[] period = new int[4];
				for(int i = 0 ; i < PERIOD_INDICATOR ; i++){
					period[i] = rs.getInt(i+1);
				}
				periodList.add(period);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(count == 0){
				System.out.println("shomthings wrong!");
			}
		}

		pstmt = null;
		
		return periodList;
	}
	
	public int getCount() {		
		try {
			pstmt = conn.prepareStatement(GET_FLOWER_COUNT);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(count == 0){
				System.out.println("shomthings wrong!");
			}
		}
		
		pstmt = null;
		
		return count;
	}
	

}

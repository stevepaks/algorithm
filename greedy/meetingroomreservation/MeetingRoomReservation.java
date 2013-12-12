package JavaProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MeetingRoomReservation {
	private List<MeetingRoom> meetings;
	private Set<MeetingRoom> reservedMeetings;
	public static void main(String[] args){
		MeetingRoomReservation meetingRoom = new MeetingRoomReservation();
		try {
			FileReader fr = new FileReader(".\\src\\JavaProgramming\\input.txt");
			BufferedReader br = new BufferedReader(fr);			
			String lex;
			
			while((lex = (String)br.readLine()) != null){
				meetingRoom.registerMeetings(lex);
			}
			
			meetingRoom.sortMeetingRooms(meetingRoom.getMeetings());
			
			for(MeetingRoom meeting : meetingRoom.getMeetings()){
				System.out.println(meeting.getRoomNo() + " " + meeting.getReservedTime()[0] + " " + meeting.getReservedTime()[1]);
			}
			meetingRoom.findUsingBest(meetingRoom.getMeetings());
			
			System.out.println("-------------------------------------");
			System.out.println(meetingRoom.getReservedMeetings().size());
			for(MeetingRoom reservedMeeting : meetingRoom.getReservedMeetings()){
				System.out.print(reservedMeeting.getRoomNo() + " ");//+ " " + reservedMeeting.getReservedTime()[0] + " " + reservedMeeting.getReservedTime()[1]);
			}
			
//			meetingRoom.setMaxMeetingInfo();
//			System.out.println(meetingRoomReservation.getNoOfMaxMeeting().iterator().next());
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findUsingBest(List<MeetingRoom> registeredMeetings){
		this.reserveMeeting(registeredMeetings.iterator().next());
		for(MeetingRoom registeredMeeting : registeredMeetings){
			Set<MeetingRoom> copyOfReservedMeetings = new HashSet<MeetingRoomReservation.MeetingRoom>();
			copyOfReservedMeetings.addAll(this.getReservedMeetings());
			
			for(MeetingRoom reservedMeeting : copyOfReservedMeetings){
				this.reserveMeeting(registeredMeeting);
				if((reservedMeeting.getReservedTime()[0] < registeredMeeting.getReservedTime()[0] && reservedMeeting.getReservedTime()[1] > registeredMeeting.getReservedTime()[0]) ||(reservedMeeting.getReservedTime()[0] < registeredMeeting.getReservedTime()[1] && reservedMeeting.getReservedTime()[1] > registeredMeeting.getReservedTime()[1])){
					this.cancleMeeting(registeredMeeting);
					break;
				}
				if((reservedMeeting.getReservedTime()[0] > registeredMeeting.getReservedTime()[0] && reservedMeeting.getReservedTime()[0] < registeredMeeting.getReservedTime()[1]) ||(reservedMeeting.getReservedTime()[1] > registeredMeeting.getReservedTime()[0] && reservedMeeting.getReservedTime()[1] < registeredMeeting.getReservedTime()[1])){
					this.cancleMeeting(registeredMeeting);
					break;
				}
			}
		}
	}
	
	protected Set<MeetingRoom> getReservedMeetings(){
		return this.reservedMeetings;
	}
	
	protected void reserveMeeting(MeetingRoom meeting){
		this.reservedMeetings.add(meeting);
	}
	
	protected void cancleMeeting(MeetingRoom meeting){
		this.reservedMeetings.remove(meeting);
	}
	
	public void sortMeetingRooms(List<MeetingRoom> meetings){
		Comparator<MeetingRoom> useTimeComparator = new MeetingRoomComparator();
		Comparator<MeetingRoom> startTimeComparator = new StartTimeComparator();
		List<Comparator<MeetingRoom>> comparatorList = new ArrayList<Comparator<MeetingRoom>>();
		comparatorList.add(startTimeComparator);
		comparatorList.add(useTimeComparator);
		for(Comparator<MeetingRoom> comparator : comparatorList){
			Collections.sort(meetings, comparator);
		}
	}
	
	public MeetingRoomReservation(){
		this.meetings = new ArrayList<MeetingRoom>();
		this.reservedMeetings = new HashSet<MeetingRoomReservation.MeetingRoom>();
	}
	
	protected List<MeetingRoom> getMeetings(){
		return this.meetings;
	}
	
	public void registerMeetings(String meeting){
		String[] word = meeting.split(" ");
		int[] duration = new int[2];
		duration[0] = Integer.parseInt(word[1]);
		duration[1] = Integer.parseInt(word[2]);
		MeetingRoom meetingRoom = new MeetingRoom(word[0], duration);
		this.meetings.add(meetingRoom);
	}
	
	public class MeetingRoomComparator implements Comparator<MeetingRoom>{

		@Override
		public int compare(MeetingRoom room1, MeetingRoom room2) {
			// TODO Auto-generated method stub
			 int useTimeOfRoom1 = room1.getReservedTime()[0] - room1.getReservedTime()[1];
			 int useTimeOfRoom2 = room2.getReservedTime()[0] - room2.getReservedTime()[1];
			 int result = useTimeOfRoom2 - useTimeOfRoom1;
			 if(result > 0){
				 return 1;
			 }else if(result < 0){
				 return -1;
			 }
			return 0;
		}		
	}
	
	public class StartTimeComparator implements Comparator<MeetingRoom>{

		@Override
		public int compare(MeetingRoom room1, MeetingRoom room2) {
			// TODO Auto-generated method stub
			 int result = room1.getReservedTime()[0] - room2.getReservedTime()[0];
			 if(result > 0){
				 return 1;
			 }else if(result < 0){
				 return -1;
			 }
			return 0;
		}		
	}
	
	public class MeetingRoom {
		private String roomNo;
		private int[] reservedTime;
		
		public MeetingRoom(String roomNo, int[] useTime){
			this.roomNo = roomNo;
			this.reservedTime = new int[2];
			this.reservedTime[0] = useTime[0];
			this.reservedTime[1] = useTime[1];
		}
		
		public String getRoomNo(){
			return this.roomNo;
		}
		
		public int[] getReservedTime(){
			return this.reservedTime;
		}
	}

}

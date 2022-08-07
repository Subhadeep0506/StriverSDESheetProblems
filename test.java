import java.util.*;
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int startMeeting[], int endMeeting[], int n){
        ArrayList<Meeting> meet = new ArrayList<>();
        
        for(int i=0; i < startMeeting.length; i++){
            meet.add(new Meeting(startMeeting[i], endMeeting[i], i+1));
        }
        
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meet,mc);

        ArrayList<Integer> res = new ArrayList<>();

        res.add(meet.get(0).posMeeting);
        int lim = meet.get(0).endMeeting;
        
        for(int i=0; i < startMeeting.length; i++){
            if(meet.get(i).startMeeting > lim){
                lim = meet.get(i).endMeeting;
                res.add(meet.get(i).posMeeting);
            }
        }
        return res.size();  
    }
}

class Meeting{
    int startMeeting;
    int endMeeting;
    int posMeeting;
    
    Meeting(int startMeeting, int endMeeting, int posMeeting){
        this.startMeeting = startMeeting;
        this.endMeeting = endMeeting;
        this.posMeeting = posMeeting;
    }
}

class MeetingComparator implements Comparator<Meeting>{
        
    @Override
    public int compare(Meeting m1, Meeting m2){
        if(m1.endMeeting < m2.endMeeting)
            return -1;
        else if(m1.endMeeting > m2.endMeeting)
            return 1;
        else if(m1.posMeeting < m2.posMeeting)
            return -1;
        return 1;
    }
}
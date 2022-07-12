package Day08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NMeetingsRoom {
    public static void main(String[] args) {
        
    }

    public static ArrayList<Integer> meetings(int[] start, int[] end, int n) {
        ArrayList<Meeting> meet = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        // Inserting each interval as an unit to the list
        for (int i = 0; i < start.length; i++) {
            meet.add(new Meeting(start[i], end[i], i + 1));
        }

        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meet, mc);
        
        res.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                res.add(meet.get(i).pos);
                limit = meet.get(i).end;
            }
        }
        return res;
    }
}

class Meeting {
    int start;
    int end;
    int pos;


    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }    
}

class MeetingComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting meeting1, Meeting meeting2) {
        if (meeting1.end < meeting2.end)
            return -1;
        else if (meeting1.end > meeting2.end)
            return 1;
        else if (meeting1.pos < meeting2.pos)
            return -1;
        return 0;
    }
}
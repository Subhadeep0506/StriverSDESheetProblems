package sdesheet.LeetCode;

public class MinimumOperationToConvertTime {
    public static void main(String[] args) {
        String current = "11:00", correct = "11:01";

        System.out.println(convertTime(current, correct));
    }

    public static int convertTime(String current, String correct) {
        int curr_mins = convertToMins(current);
        int corr_mins = convertToMins(correct);
        
        int counter = 0;
        
        while(curr_mins <= corr_mins){
            if(curr_mins + 60 <= corr_mins){
                curr_mins += 60;
                counter++;
            }
            else if(curr_mins + 15 <= corr_mins){
                curr_mins += 15;
                counter++;
            }
            else if(curr_mins + 5 <= corr_mins){
                curr_mins += 15;
                counter++;
            }
            else if(curr_mins + 1 <= corr_mins) {
                curr_mins += 1;
                counter++;
            }
        }
        
        return counter;
    }
    
    public static int convertToMins(String time){
        int h = Integer.valueOf(time.substring(0,2));
        int m = Integer.valueOf(time.substring(3,5));
        
        int result = 60*(h) + m;
        return result;
    }
}

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row,prev = null;
        
        for(int i = 0; i < numRows; i++){
            row = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                //since wkt, nth row = n col
                if(j == 0 || j == i){
                    row.add(1);
                }
                else{
                    row.add(prev.get(j-1) + prev.get(j));
                }
            }
            prev = row;
            res.add(row);
        }
        return res;
    }
    
}
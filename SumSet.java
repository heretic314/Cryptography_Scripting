import java.util.ArrayList;
import java.util.Arrays;

class SumSet {
	public static void main(String args[]) {
        Integer[] numbers = {18897109, 12828837, 9461105, 6371773, 5965343, 
        		             5946800, 5582170, 5564635, 5268860, 4552402, 4335391, 
        		             4296250, 4224851, 4192887, 3439809, 3279833, 3095313, 
        		             2812896, 2783243, 2710489, 2543482, 2356285, 2226009, 
        		             2149127, 2142508, 2134411 };
        int target = 100000000;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
    }
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
       int s = 0;
       for (int x: partial) s += x;
       if (s == target)
            System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
       if (s >= target)
            return;
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
    
}
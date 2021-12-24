import java.util.ArrayList;
import java.util.List;

public class Simple0118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<List<Integer>>(numRows);

        List<Integer> temp;
        if (numRows >= 1) {
            temp = new ArrayList(1);
            temp.add(1);
            results.add(temp);
        }

        for(int i=1; i<numRows; i++){
            temp = new ArrayList(i+1);
            temp.add(1);
            for(int j=1; j < i; j++){
                int num = results.get(i - 1).get(j - 1) + results.get(i - 1).get(j);
                temp.add(num);
            }
            temp.add(1);
            results.add(temp);
        }

        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate.toString());
    }

}

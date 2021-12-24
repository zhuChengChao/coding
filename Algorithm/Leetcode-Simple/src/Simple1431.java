import java.util.ArrayList;
import java.util.List;

public class Simple1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandie = 0;
        List<Boolean> results = new ArrayList<>();

        for(int i=0; i<candies.length; i++){
            if (maxCandie < candies[i]){
                maxCandie = candies[i];
            }
        }

        for(int i=0; i<candies.length; i++){
            if (maxCandie < candies[i]+extraCandies){
                results.add(true);
            }else{
                results.add(false);
            }
        }

        return results;
    }

}

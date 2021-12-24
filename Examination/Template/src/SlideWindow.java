import java.util.*;

public class SlideWindow {

    /* 滑动窗口算法框架 */
    void slidingWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c: t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            // [mark：和下面一个mark处的代码基本一致]

            /*** debug 输出的位置 ***/
            System.out.println("window: [" + left + "," + right +")");
            /********************/

            // 判断左侧窗口是否要收缩
            while ( /*window needs shrink*/ true) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                // [mark：和上面一个mark处的代码基本一致]
            }
        }
    }
}

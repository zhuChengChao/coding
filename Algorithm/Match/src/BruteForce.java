public class BruteForce {

    // 使用BF算法在主串T中匹配模式串P
    public static int bruteForce(String target, String pattern){
        if(target==null || target.length()==0 || pattern==null || pattern.length()>target.length()){
            return -1;
        }

        // 将单一字符串转换成数组
        char[] target_array = target.toCharArray();
        char[] pattern_array = pattern.toCharArray();

        return match(target_array, pattern_array);
    }

    private static int match(char[] target, char[] pattern){
        int i = 0; // 主串下标
        int j = 0; // 模式串下标
        int position = 0; // 匹配到的位置

        while (i < target.length && j < pattern.length){
            if (target[i] == pattern[j]){
                // 匹配成功目标串和模式串进行下一个字符的匹配
                i++;
                j++;
            }else{
                // 匹配失败，则目标字符串的下一个位置开始新匹配
                i = i - j + 1;
                j = 0;
            }
        }

        if(j != 0){
            position = i-j;
        }else {
            position = -1;
        }

        return position;
    }

    public static void main(String[] args) {
        String a = "abccbadef";
        String b = "cba";
        System.out.println("匹配下标为：" + bruteForce(a, b));
    }
}

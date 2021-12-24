public class RabinKarp {

    /**
     * 求一个字符串的hash值
     * @param str    字符串
     * @param R      对应的进制
     * @param K      将字符串映射到K的范围内
     * @param start  从str串的start位置开始
     * @param len    模式串的长度
     * @return       对应的hash值
     */
    private static int hash(String str, int R, int K, int start, int len){
        int hash = 0;
        for (int i = start; i < start+len; i++) {
            hash = (R*hash + str.charAt(i)) % K;
        }
        return hash % K;
    }

    private static boolean match(String target, String pattern, int i){
        for (int j = 0; j < pattern.length(); j++) {
            if(pattern.charAt(j) != target.charAt(j+i)){
                return false;
            }
        }
        return true;
    }

    // 使用RK算法在主串target中匹配模式串pattern
    public static int rk(String target, String pattern){
        if(target==null || target.length()==0 || pattern==null || pattern.length()>target.length()){
            return -1;
        }

        int pattern_hash = hash(pattern, 26, 31, 0, pattern.length());
        for (int i = 0; i < target.length() - pattern.length() + 1; i++) {
            if(hash(target, 26, 31, i, pattern.length()) == pattern_hash){
                if(match(target, pattern, i)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "abcedfg";
        String b = "fg";
        System.out.println("匹配下标为：" + RabinKarp.rk(a, b));
    }

}

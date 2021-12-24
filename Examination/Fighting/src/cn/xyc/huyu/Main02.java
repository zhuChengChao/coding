package cn.xyc.huyu;

import java.util.*;

public class Main02 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] nums = new int[N];
        int index = 0;
        while(index<N){
            nums[index++] = input.nextInt();
        }
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"0");
        map.put(1,"1");
        map.put(2,"10");
        map.put(3,"11");
        map.put(4,"100");
        map.put(5,"101");
        map.put(6,"110");
        map.put(7,"111");
        map.put(8,"1000");
        map.put(9,"1001");

        for (int i = 0; i < nums.length; i++) {

            StringBuilder sb = new StringBuilder();
            char[] charArray = (nums[i]+"").toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                sb.append(map.get(charArray[j]-'0'));
            }

            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < sb.length() ; j++) {
                list.add(sb.charAt(j)-'0');
            }

            Collections.reverse(list);
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j)==0){
                    list.remove(j);
                    j--;
                }else{
                    break;
                }
            }

            int zeroCount = 0, oneCount = 0;

            if(list.size() < 2){
                for(int num: list){
                    System.out.print(num);
                }
            }else{
                for (int j = 0; j < list.size(); j++) {

                    if(list.get(j) == 0){
                        oneCount = 0;
                        zeroCount ++;

                        if(zeroCount == 2){
                            list.remove(j);
                            j -= 2;

                            zeroCount = 0;
                        }
                    }else{

                        zeroCount = 0;
                        oneCount++;

                        if(oneCount == 2){
                            list.remove(j);
                            j -= 2;
                            oneCount = 0;
                        }
                    }
                }

                for(int num: list){
                    System.out.print(num);
                }
            }
            System.out.println();
        }
    }
}



package match.m175;

import java.util.HashMap;
import java.util.Map;
/**
 *  检查整数及其两倍数是否存在
 * */
public class LeetCode_5332 {

/*    public boolean checkIfExist(int[] arr) {
        Map<Integer , Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i]* 2 , i);
            if (arr[i] == 0)
                num++;
        }
        if (num> 1)
            return true;
        for (int i = 0;i < arr.length; i++) {
            if (map.get(arr[i]) != null && arr[i] != 0){
                System.out.println(arr[i]);
                return true;
            }
        }
        return false;
    }*/

    public boolean checkIfExist(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int tempInt : arr){
            //Integer tempRst = map.get(tempInt);
            if(map.keySet().contains(tempInt)){
                return true;
            }else{
                map.put(tempInt*2,tempInt);
                if(tempInt%2 == 0){
                    map.put(tempInt/2,tempInt);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LeetCode_5332 s = new LeetCode_5332();
        System.out.println(s.checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }
}

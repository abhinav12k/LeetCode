package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class subDomain {

    public static void main(String[] args) {

        String[] cp = new String[]{"9001 discuss.leetcode.com"};
        System.out.println(new Solution().subdomainVisits(cp));

    }

    static class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {

            HashMap<String,Integer> map = new HashMap();
            for(String str: cpdomains) {

                String[] arr = str.split(" ");

//                for(String st: arr){
//                    System.out.println(st);
//                }

                map.put(arr[1],map.getOrDefault(arr[1],0)+Integer.parseInt(arr[0]));

                String[] subDomains = arr[1].split("\\.",2);
                String s = subDomains[1];
                map.put(s,map.getOrDefault(s,0)+Integer.parseInt(arr[0]));

                if(s.contains(".")){
                    map.put(s.split("\\.")[1],map.getOrDefault(s.split("\\.")[1],0)+Integer.parseInt(arr[0]));
                }

            }

            List<String> ans = new ArrayList();

            for(String str: map.keySet()){
                ans.add(map.get(str) + " " + str);
            }

            return ans;
        }
    }

}

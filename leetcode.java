//problem 1 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class leetcode {
    public static void main(String[] args) {
        int nums[]= new int []{1,2,3,4,5};
        HashMap <Integer,Integer> map= new HashMap<>();
        int target= 7;
        for( int i =0;i<nums.length;i++){
            if ( map.containsKey(target-nums[i])){
                System.out.println(Arrays.toString( new int []{ map.get(target-nums[i]),i}));
                System.out.println("yes");
            }
            map.put(nums[i],i);
        }
       
    }
    
    

//problem 217 Given an integer array nums, return true if any value 
//appears at least twice in the array, and return false if every element is distinct.



    public boolean containsDuplicate(int[] nums) {
        HashSet< Integer> num = new HashSet<>();
        for( int i: nums){
            if ( num.contains(i)){
                return true;
            }
            else {
                num.add(i);
            }
        }
        return false;
    }

//problem 242  Given two strings s and t, return true if t is an 
//anagram of s, and false otherwise.
    public boolean isAnagram(String s, String t) {
        if ( s.length()!=t.length()){
            return false;

        }
        int [] match = new int[26];
        for ( int i =0;i<s.length();i++){
            match[s.charAt(i)-'a']++;
            match [t.charAt(i)-'a']--;
        }
        for( int i :match){
            if (i!=0){
                return false;
            }
            
        }
        return true;
    
}
}
// #49. Given an array of strings strs, group the anagrams
// together. You can return the answer in any order.
//Example 1:
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            char[]chars= s.toCharArray();
            Arrays.sort(chars);
            String k =new String(chars);
            if(!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(s);
        }

        return new ArrayList<>(map.values());

    }
}
// 347(top k frequent elements)
// #Given an integer array nums and an integer k, \
// return the k most frequent elements. You may return the answer in any order.
//Example 1:
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2
class Solution {
    //check the edge case
    public int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length){
            return nums;
        }
        // put the numbers in the hashmap and count its frequncy
        HashMap<Integer,Integer> map = new HashMap<>();
        for( int s : nums){

            map.put(s,map.getOrDefault(s,0)+1); // counting frequency of each unique numbers
        }
        // using the min heap to make sure we have top k frequent element
        Queue<Integer> heap = new PriorityQueue<>((a,b)->(map.get(a)-map.get(b)));
        for( int l : map.keySet()){
            heap.add(l);
            if(heap.size()>k){
                heap.poll();
            }
        }
        // return the array of top k frequent element by copying from heap to array
        int[]result=new int [k];
        for (int i=0;i<k;i++){
            result[i]=heap.poll();
        }
        return result;

    }
}
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
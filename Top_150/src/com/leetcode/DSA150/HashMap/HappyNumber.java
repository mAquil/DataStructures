package com.leetcode.DSA150.HashMap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	//Solution 1
	public static boolean isHappy(int n) {
		Set<Integer> usedIntegers = new HashSet<>();
		
		while(true) {
			int sum =0;
			
			while(n != 0) {
				sum += Math.pow(n%10, 2);
				n = n/10;
			}
			if(sum == 1)
				return true;
			
			n = sum;
			if(usedIntegers.contains(n))
				return false;
			usedIntegers.add(n);			
		}
		
	}
	
	//Solution 2
	public static boolean isHappy1(int n) {
        int count = 0;
        while(n != 1){
            int sum = 0;
            while(n > 0){
                int temp = n % 10;
                sum = sum + temp*temp;
                n = n /10;
            }
            count++;
            if(count == 10){
                return false;
            }
            n = sum;
        }
        return true;
    }
	
	//Solution 3 : Floyd’s Cycle Finding Algorithm or Hare-Tortoise algorithm
	public static boolean isHappy2(int n) {
        int slow = squaredSum(n);
        int fast = squaredSum(squaredSum(n));

        while (slow != fast) {
            slow = squaredSum(slow);
            fast = squaredSum(squaredSum(fast));
        }

        return slow == 1;
    }

    private static int squaredSum(int n) {
        int sum = 0;
        while (n > 0) {
        sum += Math.pow(n % 10, 2);
        n /= 10;
    }
    return sum;
    }
	
	public static void main(String[] args) {
		int n = 19;
		System.out.println(isHappy(n));
		System.out.println(isHappy1(n));
		System.out.println(isHappy2(n));
	}

}

package cn.leetcode;

public class Hamming {
	
	public static int hanmingHeight(int n) {
		int count =0;
		while(n!=0) {
			if((n & 1)==1) count++;
			n=n >>> 1;
		}
		return count;
	}
	

	public static int hammingDistance(int x, int y) {
		int res=0;
		
		int a= x^y;
		
		while(a!=0) {
			int b= a & 1;
			if(b==1) {
				res++;
				}
			a=a >> 1;
			}
		return res;
		}

	public static void main(String args[]) {
		
		System.out.printf("hangmingDistance is: %d \n", hammingDistance(1,4));

	}
}

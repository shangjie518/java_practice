package arrays.tij;

import java.util.Arrays;

public class ArrayEquals {

	static class Yuanqi{
		private int val;
		public Yuanqi(int v) {
			setVal(v);
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public boolean equals(Object y) {
			Yuanqi yq=(Yuanqi)y;
			if(yq.val==this.val)
				return true;
			else
				return false;
		}
	}

	public static void main(String [] args) {
		
		Object c;
		Yuanqi a[]=new Yuanqi[10];
		Yuanqi b[]=new Yuanqi[10];
		Arrays.fill(a,new Yuanqi(10));
		Arrays.fill(b, new Yuanqi(10));
		System.out.println("The arrays equal:"+Arrays.equals(a, b));
		
		
	}
}

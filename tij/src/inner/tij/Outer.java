package inner.tij;

public class Outer {
	
	private Inner[] items;
	private int cur=0;
	private int size=0;
	
	Outer(){
		System.out.println("Outer Object creating");
	}
	
	Outer(int size){
		this.size=size;
		this.items=new Inner[this.size];
		this.cur=0;
	}
	
	public void add(Inner item) {
		if(cur < size) {
			items[cur]=item;
			cur++;
		}
		if(cur==size) {
			int newSize= size +size/2;
			Inner[] newItems= new Inner[newSize];
			System.arraycopy(this.items, 0, newItems, 0, size);
			this.items=newItems;
			this.cur=size;
			this.size=newSize;
		}
		
	}
	
	public Inner getCurrentItem() {
		return items[cur-1];
	}
	
	public int length() {
		return this.size;
	}
	
	public void print() {
		StringBuilder s= new StringBuilder();
		for(int i=0;i<size;i++) {
			if(this.items[i]!=null) {
			s.append(this.items[i]+"\n");
			}
		}
		System.out.println(s.toString());
	}
	public Inner getInner() {
		return new Inner();
	}

	class Inner{
		private String stringSequence;
		
		Inner(String s){
			this.stringSequence=s;
		} 
		public String toString() {
			return stringSequence;
			
		}
		Inner(){
			System.out.println("Inner Object creating");
		}
	}
	
	public static void main(String[] args) {
		new Outer().getInner();
		Outer outer=new Outer(5);
		outer.add(outer.new Inner("Auto Train"));
		outer.add(outer.new Inner("Ferries"));
		outer.add(outer.new Inner("Tunnels"));
		outer.add(outer.new Inner("Highways"));
		outer.add(outer.new Inner("Unpaved roads"));
		outer.print();
	}
}

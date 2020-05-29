package BTDemo;

@SuppressWarnings("rawtypes")
class BinaryTree{
	class Node{
		private Comparable data;
		private Node left;
		private Node right;
		public Node(Comparable data) {
			this.data = data;
		}
		@SuppressWarnings("unchecked")
		public void addNode (Node newNode) {
			if (this.data.compareTo(newNode.data)>0)
			{
				if(left != null)
					left.addNode(newNode);
				else
					left = newNode;
			}else {
				if (right != null)
					right.addNode(newNode);
				else
					right = newNode;
			}
			
		}
		
		public void NodeToArray() {
			if (left != null)
				left.NodeToArray();
			BinaryTree.this.retData[BinaryTree.this.foot++ ] = this.data;
			if (right != null)
				right.NodeToArray();
		} 
		
	}
	private Node root;
	private Object [] retData;
	private int foot;
	private int count;
	public void add(Object data) {
		Node newNode=new Node((Comparable) data);
		if (this.root == null)
			this.root = newNode;
		else
			root.addNode(newNode);
		
		this.count ++;
	}
	
	public Object[] toArray(){
		this.foot = 0;
		this.retData = new Object [this.count];
		this.root.NodeToArray();
		return this.retData;
	}
	
}

public class BTDemo {
	public static void main(String []args) {
		
		BinaryTree bt = new BinaryTree();
		bt.add("X");
		bt.add("C");
		bt.add("A");
		bt.add("D");
		bt.add("B");
		
		Object [] results =bt.toArray();
		for (int i=0; i<results.length;i++)
			System.out.println(results[i]);
		
		
	}
	
}

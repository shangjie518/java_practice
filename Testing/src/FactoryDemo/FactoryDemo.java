package FactoryDemo;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

interface IFruit{
	public void eat();
}

class Apple implements IFruit{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Apple: Eating");
	}
	
}
class Orange implements IFruit{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Orange: Eating");
	}
	
}
class Factory{
	private Factory() {
	}
	
	public static IFruit getInstance(String Classname) {
		if ("apple".equals(Classname))
			return new Apple();
		if ("orange".equals(Classname))
			return new Orange();
		return null;
		
	}
	
}

class Pears implements Cloneable{
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}


public class FactoryDemo {

	public static void main(String args[]) {
		IFruit fruit = Factory.getInstance("apple");
		fruit.eat();
		fruit = Factory.getInstance("orange");
		fruit.eat();
		
		Map<Integer,String> testMap= new HashMap<Integer,String> ();
		System.out.println("HashMap size:"+testMap.size());
		testMap.put(1, "Walter Bishop");
		testMap.putIfAbsent(1, "Walter Bishop");
		testMap.put(2,"Peter Bishop");
		testMap.put(3, "William Bell");
		testMap.put(4,"Olivia Dunham");
		testMap.put(5,"Phillip Broyles");
		testMap.put(6,"Nina Sharp");
		testMap.put(7, "David Robert Jones");
		testMap.put(8,"Astrid Farmsworth");
		System.out.println("HashMap size:"+testMap.size());
		
		if(!testMap.isEmpty())
			System.out.println("The HashMap is not empty");
		
		System.out.printf("testing Map get %s \n", testMap.get(1));
		
		Iterator<Map.Entry<Integer, String>> iter = testMap.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, String> temp= iter.next();
			System.out.printf("%d: %s \n", temp.getKey(),temp.getValue());
		}
		
		Set <String> testLinkedHashSet=new LinkedHashSet<String>();
		Deque<String> testll= new LinkedList<String>();
		
		
	}
}

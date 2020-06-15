package proxy.tij;

import org.junit.Test;

public class runTest {

	@Test
	public void test() {
		Agent agent=new Agent();
		Person p=agent.getProxy();
		String val1=p.dance("Disco");
		System.out.println(val1);
		String val2=p.sing("Trampoline");
		System.out.println(val2);
	}
}

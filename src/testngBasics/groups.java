package testngBasics;

import org.testng.annotations.Test;

public class groups {

	@Test(groups = { "smoke", "regression" })
	public void method1() {
		System.out.println("method: 1");

	}

	@Test(groups = { "smoke" })
	public void method2() {
		System.out.println("method: 2");

	}
}

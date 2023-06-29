package package_01;

import org.testng.annotations.Test;

public class groups2 {

	@Test(groups = { "smoke", "regression" })
	public void method11() {
		System.out.println("method: 11");

	}

	@Test(groups = { "smoke" })
	public void method22() {
		System.out.println("method: 22");

	}
}

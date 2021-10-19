import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class evalPostTest {

	@Test
	void test() {
		ResizeableArrayStack<String> test = new ResizeableArrayStack<String>();
		int output = test.evaluatePostfix("62/12+*");
		assertEquals(9, output);
	}

}

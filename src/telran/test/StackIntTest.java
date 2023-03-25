package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import telran.util.*;

import org.junit.jupiter.api.Test;

class StackIntTest {
	StackInt st = new StackInt();
	
	@Test
	void isEmptyTest() {
		assertTrue(st.isEmpty());
		st.push(10);
		assertFalse(st.isEmpty());
		st.pop();
		assertTrue(st.isEmpty());
	}
	
	@Test
	void pushTest() {
		st.push(5);
		assertEquals(5, st.pop());
		st.push(10);
		assertEquals(10, st.pop());
		st.push(2);
		assertEquals(2, st.pop());
		st.push(0);
		assertEquals(0, st.pop());
	}
	
	@Test
	void popTest() {
		st.push(5);
		st.push(10);
		st.push(2);
		st.push(0);
		assertEquals(0, st.pop());
		assertEquals(2, st.pop());
		assertEquals(10, st.pop());
		assertEquals(5, st.pop());
	}
	
	@Test
	void getMaxTest() throws Exception {
		st.push(7);
		assertEquals(7, st.getMax());
		st.push(5);
		assertEquals(7, st.getMax());
		st.push(10);
		assertEquals(10, st.getMax());
		st.push(2);
		assertEquals(10, st.getMax());
		
		assertEquals(2, st.pop());
		assertEquals(10, st.getMax());
		assertEquals(10, st.pop());
		assertEquals(7, st.getMax());
		assertEquals(5, st.pop());
		assertEquals(7, st.getMax());
		assertEquals(7, st.pop());
	}
}

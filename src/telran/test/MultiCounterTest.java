package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.structure.MultiCounters;
import telran.structure.MultiCountersSol;

class MulticountersTest {
	   MultiCounters multiCounter;
		@BeforeEach
		void setUp() throws Exception {
			multiCounter = new MultiCountersSol();
			multiCounter.addItem(10);
			multiCounter.addItem(10);
			multiCounter.addItem(10);
			multiCounter.addItem("abc");
			multiCounter.addItem("abc");
			multiCounter.addItem("lmn");
			multiCounter.addItem("lmn");
		}

		@Test
		void getMaxItemsTest() throws Exception {
			runTest(Arrays.asList(10));
		}

		private void runTest(List<Object> list) throws Exception {
			var set = multiCounter.getMaxItems();
			list.forEach((item)-> assertTrue(set.contains(item)));
			
		}
		@Test
		void getValueTest() throws Exception {
			assertEquals(3, multiCounter.getValue(10));
			assertNull(multiCounter.getValue("kuku"));
		}
		@Test
		void addItemTest() throws Exception {
			Object[] items = {10, "abc"};
			assertEquals(3,multiCounter.addItem("abc"));
			runTest(Arrays.asList(items));
			
		}
		@Test
		void removeItemTest() throws Exception {
			Object[] items = {"abc", "lmn"};
			assertTrue(multiCounter.remove(10));
			runTest(Arrays.asList(items));
			assertFalse(multiCounter.remove(10));
		}
		

	}

package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Connection;
import telran.util.ConnectionsPoolSol;

class ConnectionsPoolTest {
	ConnectionsPoolSol pool = new ConnectionsPoolSol();

	@BeforeEach
	void setUp() {
		pool.addConnection(new Connection(11, "aaa", 1));
		pool.addConnection(new Connection(22, "bbb", 2));
		pool.addConnection(new Connection(33, "ccc", 3));
		pool.addConnection(new Connection(44, "ddd", 4));
		pool.addConnection(new Connection(55, "eee", 5));
	}

	@Test
	void connectionTest() {
		LinkedList<Integer> list = pool.getUsingOrder();
		System.out.println(list);

		assertFalse(pool.addConnection(new Connection(33, "ccc", 3)));
		assertEquals("ccc", pool.getConnection(33).getIpAddress());
		
		assertTrue(pool.addConnection(new Connection(66, "fff", 6)));
		assertEquals("fff", pool.getConnection(66).getIpAddress());

		assertEquals("bbb", pool.getConnection(22).getIpAddress());
		
		assertTrue(pool.addConnection(new Connection(11, "aaa", 1)));

		assertEquals(null, pool.getConnection(44));
		System.out.println(list);
	}
}

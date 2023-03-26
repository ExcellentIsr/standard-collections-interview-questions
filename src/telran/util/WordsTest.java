package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsTest {
	WordsSol sol = new WordsSol();
	@BeforeEach
	void setUp() throws Exception {
		sol.addWord("TelMan");
		sol.addWord("telman");
		sol.addWord(".TelRun");
		sol.addWord("Telrun");
		sol.addWord(" ");
		sol.addWord("TlRn");
		sol.addWord("TelRun");
		sol.addWord("$$$");
		sol.addWord("TelGun");
	}

	@Test
	void test() {
		List<String> list = sol.getWordsByPrefix("Tel");
		for (String s : list) {
			System.out.println(s);
		}
	}

}

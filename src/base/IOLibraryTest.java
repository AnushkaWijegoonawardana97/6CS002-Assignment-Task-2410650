package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.InetAddress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IOLibraryTest {

	private InputStream originalSystemIn;

	@Before
	public void setUp() {
		originalSystemIn = System.in;
	}

	@After
	public void tearDown() {
		System.setIn(originalSystemIn);
	}

	@Test
	public void testGetString() {
		String userInput = "Hello, world!";
		provideInput(userInput);

		String result = IOLibrary.getString();

		assertEquals(userInput, result);
	}

	@Test
	public void testGetIPAddress() {
		String ipAddressInput = "192.168.0.1";
		provideInput(ipAddressInput);

		InetAddress result = IOLibrary.getIPAddress();

		assertNotNull(result);
		assertEquals(ipAddressInput, result.getHostAddress());
	}

	private void provideInput(String input) {
		System.setIn(new ByteArrayInputStream(input.getBytes()));
	}
}
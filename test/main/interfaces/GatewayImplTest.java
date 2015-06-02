package main.interfaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import main.interfaces.impl.GatewayImpl;

import org.junit.Before;
import org.junit.Test;


public class GatewayImplTest {
	
	private Gateway gateway;
	
	@Before
	public void setUp() {
		gateway = new GatewayImpl();
	}
	
	@Test
	public void getMessagesTestInstanceOf() {
		assertTrue(gateway.getMessages() instanceof List<?>);
	}
	
	@Test
	public void getMessageTestSize() {
		assertEquals(gateway.getMessages().size(), 50);
	}
	
	@Test
	public void getMessageNotNullElements() {
		assertNotNull(gateway.getMessages().get(0).getGroupId());
		assertNotNull(gateway.getMessages().get(0).getMessage());
	}
	
}

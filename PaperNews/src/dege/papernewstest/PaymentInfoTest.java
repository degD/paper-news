package dege.papernewstest;

import dege.papernews.*;

import static org.junit.Assert.*;
import org.junit.Test;


public class PaymentInfoTest {

	@Test
	public void testIncreasePayment() {
		PaymentInfo p = new PaymentInfo(0);
		assertEquals(0,  p.getReceivedPayment(), 0.001);
		p.increasePayment(100);
		assertEquals(100, p.getReceivedPayment(), 0.001);
	}
}

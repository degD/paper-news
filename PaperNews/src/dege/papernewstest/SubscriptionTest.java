package dege.papernewstest;

import dege.papernews.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubscriptionTest {
	
	private Journal j1, j2, j3;
	private Subscriber s1, s2;
	private Subscription subs;
	private DateInfo d;

	@Before
	public void setup() {
		j1 = new Journal("j1", "1234", 12, 50);
		j2 = new Journal("j2", "345b", 6, 75);
		j3 = new Journal("j3", "8fa9", 2, 30);
		
		s1 = new Individual("s1", "addr1");
		s2 = new Corporation("s2", "addr2");
		
		d = new DateInfo(4, 2022);
	}
	
	@Test
	public void discountCalc() {
		// Discount calculation test.
		subs = new Subscription(d, 2, j1, s1);
		assertEquals(0, subs.getPayment().getDiscountRatio(), 0.001);
		subs = new Subscription(d, 15, j2, s2);
		assertEquals(10, subs.getPayment().getDiscountRatio(), 0.001);
		
		// Issue price calculation test.
		assertEquals(75 * 9.0/10.0, subs.getIssuePriceWithDiscount(), 0.001);
	}
}

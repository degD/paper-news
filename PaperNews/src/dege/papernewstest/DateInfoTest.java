package dege.papernewstest;

import dege.papernews.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateInfoTest {
	
	private DateInfo date1;
	private DateInfo date2;
	
	@Before
	public void setup() {
		date1 = new DateInfo(8, 2021);
		date2 = new DateInfo(1, 2024);
	}
	
	@Test
	public void testEndMonth() {
		assertEquals("Error in endMonth", 7, date1.getEndMonth());
		assertEquals("Error in endMonth", 12, date2.getEndMonth());
	}
	
	@Test
	public void testEndYear() {
		assertEquals("Error in endYear", 2022, date1.getEndYear());
		assertEquals("Error in endYear", 2024, date2.getEndYear());
	}
}

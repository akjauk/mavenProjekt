package de.hfu;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
	
	@Test
	public void testIstErstesHalbjahr() {
		int month = 6;
		assertTrue("Monat Juni liegt im ersten Halbjahr", Util.istErstesHalbjahr(month));
	}
	
	@Test
	public void testIstNichtErstesHalbjahr() {
		int month = 7;
		assertTrue("Monat Juli liegt nicht im ersten Halbjahr", !Util.istErstesHalbjahr(month));
	}
	
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testKeinMonat() {
		Util.istErstesHalbjahr(0);
	}
	
}

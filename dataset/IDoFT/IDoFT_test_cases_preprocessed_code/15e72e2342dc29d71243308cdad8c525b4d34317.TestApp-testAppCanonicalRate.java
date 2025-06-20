/** 
 * Test Canonical Rates. 
 */
@Test public void testAppCanonicalRate() throws Exception {
assertEquals(28,metrics.size());
assertEquals(30,metrics.size());
Thread.sleep(5000);
assertEquals(29,metrics.size());
assertEquals(30,metrics.size());
Thread.sleep(5000);
assertEquals(30,metrics.size());
}
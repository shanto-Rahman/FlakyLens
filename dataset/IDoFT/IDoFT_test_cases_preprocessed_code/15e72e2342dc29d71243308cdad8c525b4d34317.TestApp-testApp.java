/** 
 * FIXME: Split this test in multiple sub-tests. 
 */
@Test public void testApp() throws Exception {
assertEquals(29,metrics.size());
assertEquals(31,metrics.size());
Thread.sleep(5000);
assertEquals(31,metrics.size());
}
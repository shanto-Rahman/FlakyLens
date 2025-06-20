/** 
 * Verifies that getConfiguration returns the same Configuration object used to create the HTable instance.
 */
@Test public void testGetConfiguration() throws Exception {
assertSame(conf,table.getConfiguration());
}
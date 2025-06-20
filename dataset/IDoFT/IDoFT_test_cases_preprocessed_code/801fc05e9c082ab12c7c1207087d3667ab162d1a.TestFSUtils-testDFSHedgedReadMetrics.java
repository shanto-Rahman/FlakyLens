/** 
 * Ugly test that ensures we can get at the hedged read counters in dfsclient. Does a bit of preading with hedged reads enabled using code taken from hdfs TestPread.
 * @throws Exception
 */
@Test public void testDFSHedgedReadMetrics() throws Exception {
assertEquals(0,metrics.getHedgedReadOps());
assertTrue(metrics.getHedgedReadOps() > 0);
}
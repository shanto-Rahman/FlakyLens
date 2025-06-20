/** 
 * Tests that node discovery times out after additional-node-timeout, after the first node has been discovered. This method tests the use case when affinity is None. If the test method timed out, then the additional-node-timeout system property didn't take effect.
 */
@Test(timeout=4000) public void testDiscoveryTimeoutWithoutAffinity() throws Exception {
}
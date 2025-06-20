/** 
 * In 2482, a RS with an opening region on it dies.  The said region is then stuck in the master's regions-in-transition and never leaves it.  This test works by bringing up a new regionserver, waiting for the load balancer to give it some regions.  Then, we close all on the new server. After sending all the close messages, we send the new regionserver the special blocking message so it can not process any more messages. Meantime reopening of the just-closed regions is backed up on the new server.  Soon as master gets an opening region from the new regionserver, we kill it.  We then wait on all regions to come back on line.  If bug is fixed, this should happen soon as the processing of the killed server is done.
 * @see  <a href="https://issues.apache.org/jira/browse/HBASE-2482">HBASE-2482</a> 
 */
@Test(timeout=300000) public void testKillRSWithOpeningRegion2482() throws Exception {
if (cluster.getLiveRegionServerThreads().size() < 2) {
}
}
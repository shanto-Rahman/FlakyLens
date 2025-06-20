/** 
 * In 2428, the meta region has just been set offline and then a close comes in.
 * @see  <a href="https://issues.apache.org/jira/browse/HBASE-2428">HBASE-2428</a> 
 */
@Test(timeout=300000) public void testRegionCloseWhenNoMetaHBase2428() throws Exception {
if (i == metaIndex) continue;
while (!listener.isDone()) Threads.sleep(10);//IT
assertTrue(listener.getCloseCount() > 1);//IT
assertTrue(listener.getCloseCount() < ((HBase2428Listener.SERVER_DURATION / HBase2428Listener.CLOSE_DURATION) * 2));//IT
}
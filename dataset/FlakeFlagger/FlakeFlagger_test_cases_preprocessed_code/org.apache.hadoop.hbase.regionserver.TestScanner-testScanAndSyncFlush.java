/** 
 * Tests to do a sync flush during the middle of a scan. This is testing the StoreScanner update readers code essentially.  This is not highly concurrent, since its all 1 thread. HBase-910.
 * @throws Exception
 */
public void testScanAndSyncFlush() throws Exception {
assertEquals(count,count(hri,100,false));
}
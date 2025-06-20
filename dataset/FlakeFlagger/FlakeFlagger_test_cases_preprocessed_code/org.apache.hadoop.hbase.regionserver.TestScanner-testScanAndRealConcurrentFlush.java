/** 
 * Tests to do a concurrent flush (using a 2nd thread) while scanning.  This tests both the StoreScanner update readers and the transition from memstore -> snapshot -> store file.
 * @throws Exception
 */
public void testScanAndRealConcurrentFlush() throws Exception {
assertEquals(count,count(hri,100,true));
}
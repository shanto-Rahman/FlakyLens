/** 
 * Test that closing a scanner while a client is using it doesn't throw NPEs but instead a UnknownScannerException. HBASE-2503
 * @throws Exception
 */
public void testRaceBetweenClientAndTimeout() throws Exception {
fail("We don't want anything more, we should be failing");
}
/** 
 * Test that we do get a ScannerTimeoutException
 * @throws Exception
 */
@Test public void test2481() throws Exception {
if (count == 5) {
Thread.sleep(1500);
}
fail("We should be timing out");
}
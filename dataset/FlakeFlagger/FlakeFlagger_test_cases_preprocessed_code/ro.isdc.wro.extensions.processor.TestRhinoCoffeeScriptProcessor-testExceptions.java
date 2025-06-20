/** 
 * Test that by default, failing to process a js with coffeeScript, will leave the result unchanged.
 */
@Test public void testExceptions() throws IOException {
counter.incrementAndGet();
final File testFolder=new File(url.getFile(),"test");
final File expectedFolder=new File(url.getFile(),"expected");
Assert.assertEquals(2,counter.get());
}
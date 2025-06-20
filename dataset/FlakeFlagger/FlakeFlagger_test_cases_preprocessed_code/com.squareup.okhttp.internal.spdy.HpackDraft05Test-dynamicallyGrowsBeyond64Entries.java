/** 
 * Header table backing array is initially 8 long, let's ensure it grows. 
 */
@Test public void dynamicallyGrowsBeyond64Entries() throws IOException {
assertEquals(256,hpackReader.headerCount);
}
/** 
 * This message should not be compressed as it is too small
 * @throws IOException
 */
@Test public void testSmallMessagePredicateDoesNotCompress() throws IOException {
message="Hi";//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(0,header.length);
Assert.assertEquals("Hi",body);
}
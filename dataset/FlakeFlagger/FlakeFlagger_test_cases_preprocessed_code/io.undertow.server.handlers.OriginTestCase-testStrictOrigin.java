/** 
 * Tests the Origin header is respected when the strictest options are selected
 */
@Test public void testStrictOrigin() throws IOException {
Assert.assertEquals(403,result.getStatusLine().getStatusCode());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(403,result.getStatusLine().getStatusCode());
Assert.assertEquals(403,result.getStatusLine().getStatusCode());
}
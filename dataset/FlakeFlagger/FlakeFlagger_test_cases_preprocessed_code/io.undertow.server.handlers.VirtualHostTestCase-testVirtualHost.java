/** 
 * Tests the Origin header is respected when the strictest options are selected
 */
@Test public void testVirtualHost() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("localhost",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("default",header[0].getValue());
}
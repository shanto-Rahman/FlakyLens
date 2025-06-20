/** 
 * Tests encoding selection with a qvalue
 * @throws IOException
 */
@Test public void testEncodingSelectWithQValue() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
Assert.assertEquals(406,result.getStatusLine().getStatusCode());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("compress",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
}
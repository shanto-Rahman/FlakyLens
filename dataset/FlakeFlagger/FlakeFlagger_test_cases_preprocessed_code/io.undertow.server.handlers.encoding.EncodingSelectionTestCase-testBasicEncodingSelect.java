/** 
 * Tests encoding selection with no qvalue <p/> Also tests a lot of non standard formats for Accept-Encoding to make sure that we are liberal in what we accept
 * @throws IOException
 */
@Test public void testBasicEncodingSelect() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(0,header.length);
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("compress",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("compress",header[0].getValue());
}
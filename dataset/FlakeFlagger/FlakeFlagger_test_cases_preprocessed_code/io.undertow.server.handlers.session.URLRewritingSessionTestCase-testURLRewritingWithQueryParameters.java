@Test public void testURLRewritingWithQueryParameters() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("0",header[0].getValue());
Assert.assertEquals("b",result.getHeaders("a")[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("1",header[0].getValue());
Assert.assertEquals("b",result.getHeaders("a")[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("2",header[0].getValue());
Assert.assertEquals("b",result.getHeaders("a")[0].getValue());
}
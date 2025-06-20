@Test public void testEncodingSelectionWithQValueAndPredicate() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
Assert.assertEquals(406,result.getStatusLine().getStatusCode());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(0,header.length);
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("bzip",header[0].getValue());
}
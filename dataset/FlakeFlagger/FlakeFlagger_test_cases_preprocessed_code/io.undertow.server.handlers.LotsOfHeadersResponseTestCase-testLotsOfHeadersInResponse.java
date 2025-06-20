@Test public void testLotsOfHeadersInResponse() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(MESSAGE + i,header[0].getValue());
}
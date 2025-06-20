@Test public void sendHttpOneZeroRequest() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("MyValue",header[0].getValue());
}
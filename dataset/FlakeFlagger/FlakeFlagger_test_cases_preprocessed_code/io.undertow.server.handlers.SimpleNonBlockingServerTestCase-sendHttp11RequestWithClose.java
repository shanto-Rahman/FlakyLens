@Test public void sendHttp11RequestWithClose() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("MyValue",header[0].getValue());
}
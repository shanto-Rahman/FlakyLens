@Test public void testSslLotsOfData() throws IOException, GeneralSecurityException, URISyntaxException {
if (exchange.isInIoThread()) {
}
post.setEntity(new StringEntity(message));//RW
Assert.assertEquals(200,resultList.getStatusLine().getStatusCode());
Assert.assertEquals(message,response);//RW
post.setEntity(new StringEntity(message));//RW
Assert.assertEquals(200,resultList.getStatusLine().getStatusCode());
Assert.assertEquals(message,response);//RW
}
@Test public void testFixedLengthRequest() throws IOException {
connection=null;//RW
post.setEntity(new StringEntity(message));//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
post.setEntity(new StringEntity(message));//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
}
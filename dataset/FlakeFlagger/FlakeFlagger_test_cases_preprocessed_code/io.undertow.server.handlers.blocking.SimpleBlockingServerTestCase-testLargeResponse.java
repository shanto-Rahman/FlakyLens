@Test public void testLargeResponse() throws IOException {
message=messageBuilder.toString();//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(message.length(),resultString.length());//RW
Assert.assertTrue(message.equals(resultString));//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertTrue(message.equals(resultBody));//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertTrue(message.equals(resultBody));//RW
}
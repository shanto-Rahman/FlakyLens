@Test public void testRedirectHandler() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("/target/path/a",message);//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("/target/matched/aab",message);//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("/target/matched/aab",message);//RW
}
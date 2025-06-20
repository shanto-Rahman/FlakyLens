@Test public void testRewrite() throws Exception {
assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals("A file",result);
Assert.assertEquals(1,headers.length);
Assert.assertEquals("MyValue",headers[0].getValue());
}
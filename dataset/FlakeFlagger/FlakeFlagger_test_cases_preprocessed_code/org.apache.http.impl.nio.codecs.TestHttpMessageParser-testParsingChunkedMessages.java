@Test public void testParsingChunkedMessages() throws Exception {
Assert.assertNull(request);
Assert.assertNull(request);
Assert.assertNotNull(request);
Assert.assertEquals("/whatever",request.getRequestLine().getUri());
Assert.assertEquals(1,request.getAllHeaders().length);
}
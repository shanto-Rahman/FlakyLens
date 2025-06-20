@Test public void testSimpleParsing() throws Exception {
Assert.assertNotNull(request);
Assert.assertEquals("/whatever",request.getRequestLine().getUri());
Assert.assertEquals(1,request.getAllHeaders().length);
}
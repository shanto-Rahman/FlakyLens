@Test public void testParsingIncompleteRequestLine() throws Exception {
Assert.assertNotNull(request);
Assert.assertEquals(HttpVersion.HTTP_1_0,request.getRequestLine().getProtocolVersion());
}
@Test public void testParsingIncompleteHeader() throws Exception {
Assert.assertNotNull(request);
Assert.assertEquals(1,request.getAllHeaders().length);
Assert.assertEquals("whatever",request.getFirstHeader("Header").getValue());
}
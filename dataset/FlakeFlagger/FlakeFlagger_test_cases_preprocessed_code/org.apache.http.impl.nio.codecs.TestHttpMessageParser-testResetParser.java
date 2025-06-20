@Test public void testResetParser() throws Exception {
Assert.assertNotNull(request);
Assert.assertEquals(1,request.getAllHeaders().length);
Assert.assertEquals("one",request.getFirstHeader("Header").getValue());
Assert.assertNotNull(request);
Assert.assertEquals(1,request.getAllHeaders().length);
Assert.assertEquals("two",request.getFirstHeader("Header").getValue());
}
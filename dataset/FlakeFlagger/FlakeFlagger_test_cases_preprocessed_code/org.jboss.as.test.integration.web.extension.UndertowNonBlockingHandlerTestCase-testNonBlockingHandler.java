@Test public void testNonBlockingHandler() throws Exception {
assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals(SimpleUndertowExtension.THIS_IS_NOT_A_SERVLET,result);
}
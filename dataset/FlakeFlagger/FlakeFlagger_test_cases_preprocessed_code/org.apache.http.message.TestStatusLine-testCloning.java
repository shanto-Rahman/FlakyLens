@Test public void testCloning() throws Exception {
Assert.assertEquals(orig.getReasonPhrase(),clone.getReasonPhrase());
Assert.assertEquals(orig.getStatusCode(),clone.getStatusCode());
Assert.assertEquals(orig.getProtocolVersion(),clone.getProtocolVersion());
}
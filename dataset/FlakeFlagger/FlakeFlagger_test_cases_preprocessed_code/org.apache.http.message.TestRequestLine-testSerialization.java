@Test public void testSerialization() throws Exception {
Assert.assertEquals(orig.getMethod(),clone.getMethod());
Assert.assertEquals(orig.getUri(),clone.getUri());
Assert.assertEquals(orig.getProtocolVersion(),clone.getProtocolVersion());
}
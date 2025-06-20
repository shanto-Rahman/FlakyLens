@Test public void testRequestContentTypeAndEncoding() throws Exception {
Assert.assertNotNull(h1);
Assert.assertEquals("whatever",h1.getValue());
Assert.assertNotNull(h2);
Assert.assertEquals("whatever",h2.getValue());
}
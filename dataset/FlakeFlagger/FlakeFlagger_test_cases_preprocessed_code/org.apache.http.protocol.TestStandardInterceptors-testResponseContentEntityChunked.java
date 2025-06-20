@Test public void testResponseContentEntityChunked() throws Exception {
Assert.assertNotNull(h1);
Assert.assertEquals(HTTP.CHUNK_CODING,h1.getValue());
Assert.assertNull(h2);
}
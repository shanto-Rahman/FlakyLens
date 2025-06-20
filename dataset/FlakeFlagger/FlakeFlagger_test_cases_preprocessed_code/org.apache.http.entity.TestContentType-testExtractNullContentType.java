@Test public void testExtractNullContentType() throws Exception {
Assert.assertNull(ContentType.get(httpentity));
}
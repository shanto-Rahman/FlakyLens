@Test public void testEntityContentEncoding() throws Exception {
Assert.assertNotNull(entity);
Assert.assertNotNull(entity.getContentEncoding());
Assert.assertEquals("what not",entity.getContentEncoding().getValue());
}
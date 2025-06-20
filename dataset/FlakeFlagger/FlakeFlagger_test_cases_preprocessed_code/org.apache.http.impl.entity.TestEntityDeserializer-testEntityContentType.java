@Test public void testEntityContentType() throws Exception {
Assert.assertNotNull(entity);
Assert.assertNotNull(entity.getContentType());
Assert.assertEquals("stuff",entity.getContentType().getValue());
}
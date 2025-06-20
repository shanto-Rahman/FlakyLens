@Test public void testDefaultContent() throws Exception {
Assert.assertEquals("text/csv; charset=ansi_x3.4-1968",httpentity.getContentType().getValue());
Assert.assertEquals("text/plain; charset=us-ascii",httpentity.getContentType().getValue());
Assert.assertEquals("text/plain; charset=ISO-8859-1",httpentity.getContentType().getValue());
}
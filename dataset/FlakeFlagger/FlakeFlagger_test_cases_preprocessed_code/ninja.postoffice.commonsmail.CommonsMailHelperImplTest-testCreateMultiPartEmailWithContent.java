@Test public void testCreateMultiPartEmailWithContent() throws Exception {
assertTrue(multiPartEmail instanceof MultiPartEmail);
assertTrue(multiPartEmail instanceof HtmlEmail);
assertTrue(multiPartEmail instanceof HtmlEmail);
}
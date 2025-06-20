/** 
 * Tests meta info: title, author, subject, keywords.
 */
@Test public void testMetaInformation() throws IOException {
  PDDocument doc=run("meta-information");
  PDDocumentInformation did=doc.getDocumentInformation();
  assertThat(did.getTitle(),equalTo("Test title"));
  assertThat(did.getAuthor(),equalTo("Test author"));
  assertThat(did.getSubject(),equalTo("Test subject"));
  assertThat(did.getKeywords(),equalTo("Test keywords"));
  remove("meta-information",doc);
}

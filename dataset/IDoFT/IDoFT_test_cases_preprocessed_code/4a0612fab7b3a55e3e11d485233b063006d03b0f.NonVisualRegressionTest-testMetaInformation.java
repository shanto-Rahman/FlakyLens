/** 
 * Tests meta info: title, author, subject, keywords.
 */
@Test public void testMetaInformation() throws IOException {
assertThat(did.getTitle(),equalTo("Test title"));
assertThat(did.getAuthor(),equalTo("Test author"));
assertThat(did.getSubject(),equalTo("Test subject"));
assertThat(did.getKeywords(),equalTo("Test keywords"));
}
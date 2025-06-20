@Test public void testGetAndPostArticleViaXml() throws Exception {
assertEquals(3,articlesDto.articles.size());
assertTrue(response.contains("Error. Forbidden."));
assertFalse(response.contains("Error. Forbidden."));
assertEquals(4,articlesDto.articles.size());
}
@Test public void testThatPostArticleReturnsNotFoundWhenArticleDaoReturnsFalse(){
assertEquals(404,result.getStatusCode());
}
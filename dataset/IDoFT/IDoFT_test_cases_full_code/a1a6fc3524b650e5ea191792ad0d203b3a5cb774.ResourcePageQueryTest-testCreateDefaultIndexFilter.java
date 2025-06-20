@Test public void testCreateDefaultIndexFilter(){
  String resultRequestPath=ResourcePageQuery.indexPageQuery().apply(webTarget).getUri().toString();
  assertEquals(DEFAULT_URL + "?startIndex=1&count=100",resultRequestPath);
}

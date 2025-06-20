@Test public void testCreateCustomIndexFilter(){
  int startIndex=1;
  int count=50;
  String resultRequestPath=ResourcePageQuery.indexPageQuery().withStartIndex(startIndex).withCount(count).apply(webTarget).getUri().toString();
  assertEquals(String.format("%s?startIndex=%d&count=%d",DEFAULT_URL,startIndex,count),resultRequestPath);
}

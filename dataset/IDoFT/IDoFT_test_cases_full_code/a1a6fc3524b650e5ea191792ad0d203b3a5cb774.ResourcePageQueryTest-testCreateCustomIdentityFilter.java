@Test public void testCreateCustomIdentityFilter(){
  String startId="00000000-0000-1000-9000-000000000000";
  int count=50;
  String resultRequestPath=ResourcePageQuery.identityPageQuery().withStartId(startId).withCount(count).apply(webTarget).getUri().toString();
  assertEquals(String.format("%s?startId=%s&count=%d",DEFAULT_URL,startId,count),resultRequestPath);
}

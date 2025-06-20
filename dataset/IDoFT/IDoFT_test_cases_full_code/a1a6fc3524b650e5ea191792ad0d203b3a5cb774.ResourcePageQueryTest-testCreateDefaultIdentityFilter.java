@Test public void testCreateDefaultIdentityFilter(){
  String resultRequestPath=ResourcePageQuery.identityPageQuery().apply(webTarget).getUri().toString();
  assertEquals(DEFAULT_URL + "?startId=00000000-0000-1000-9000-000000000000&count=100",resultRequestPath);
}

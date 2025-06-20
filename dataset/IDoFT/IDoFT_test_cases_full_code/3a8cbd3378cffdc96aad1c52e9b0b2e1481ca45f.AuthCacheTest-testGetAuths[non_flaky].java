@Test public void testGetAuths() throws Exception {
  Collection<Authorizations> auths=AuthCache.getAuthorizations(cookie);
  Assert.assertEquals(1,auths.size());
  Authorizations a=auths.iterator().next();
  String[] authStrings=a.toString().split(",");
  Arrays.sort(authStrings);
  Assert.assertEquals("[A, B, C]",Arrays.toString(authStrings));
}

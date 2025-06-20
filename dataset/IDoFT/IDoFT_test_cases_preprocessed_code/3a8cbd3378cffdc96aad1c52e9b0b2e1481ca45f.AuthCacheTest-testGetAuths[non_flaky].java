@Test public void testGetAuths() throws Exception {
Collection<Authorizations> auths=AuthCache.getAuthorizations(cookie);//RW
Assert.assertEquals(1,auths.size());
Assert.assertEquals("[A, B, C]",Arrays.toString(authStrings));
}
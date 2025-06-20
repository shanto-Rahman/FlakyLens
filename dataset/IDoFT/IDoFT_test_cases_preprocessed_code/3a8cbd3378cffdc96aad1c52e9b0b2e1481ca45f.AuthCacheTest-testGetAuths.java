@Test public void testGetAuths() throws Exception {
Authorizations a=AuthCache.getAuthorizations(cookie);//RW
Assert.assertEquals("A,B,C",a.toString());
}
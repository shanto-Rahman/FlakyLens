@Test public void testSearchUsersWithFilter() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,null);
  when(configurationContext.getProperty(PROP_USER_IDENTITY_ATTRIBUTE)).thenReturn(new StandardPropertyValue("uid",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_USER_SEARCH_FILTER)).thenReturn(new StandardPropertyValue("(uid=user1)",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(1,ldapUserGroupProvider.getUsers().size());
  assertNotNull(ldapUserGroupProvider.getUserByIdentity("user1"));
  assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}

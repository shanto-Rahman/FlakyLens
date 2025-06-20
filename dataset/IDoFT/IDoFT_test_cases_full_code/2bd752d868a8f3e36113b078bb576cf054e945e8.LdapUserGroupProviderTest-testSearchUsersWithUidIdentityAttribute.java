@Test public void testSearchUsersWithUidIdentityAttribute() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,null);
  when(configurationContext.getProperty(PROP_USER_IDENTITY_ATTRIBUTE)).thenReturn(new StandardPropertyValue("uid",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(8,ldapUserGroupProvider.getUsers().size());
  assertNotNull(ldapUserGroupProvider.getUserByIdentity("user1"));
  assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}

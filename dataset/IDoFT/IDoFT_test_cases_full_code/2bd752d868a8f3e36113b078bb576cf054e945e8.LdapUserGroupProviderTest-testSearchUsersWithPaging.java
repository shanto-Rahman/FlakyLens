@Test public void testSearchUsersWithPaging() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,null);
  when(configurationContext.getProperty(PROP_PAGE_SIZE)).thenReturn(new StandardPropertyValue("1",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(8,ldapUserGroupProvider.getUsers().size());
  assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}

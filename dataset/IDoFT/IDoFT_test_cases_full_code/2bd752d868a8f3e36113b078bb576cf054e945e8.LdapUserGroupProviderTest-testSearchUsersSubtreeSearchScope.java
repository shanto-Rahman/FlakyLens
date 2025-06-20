@Test public void testSearchUsersSubtreeSearchScope() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration("o=nifi",null);
  when(configurationContext.getProperty(PROP_USER_SEARCH_SCOPE)).thenReturn(new StandardPropertyValue(SearchScope.SUBTREE.name(),null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(9,ldapUserGroupProvider.getUsers().size());
  assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}

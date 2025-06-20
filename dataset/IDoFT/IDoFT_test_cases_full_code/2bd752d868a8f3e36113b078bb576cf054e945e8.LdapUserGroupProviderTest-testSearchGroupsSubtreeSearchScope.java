@Test public void testSearchGroupsSubtreeSearchScope() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(null,"o=nifi");
  when(configurationContext.getProperty(PROP_GROUP_MEMBER_ATTRIBUTE)).thenReturn(new StandardPropertyValue("member",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_SEARCH_SCOPE)).thenReturn(new StandardPropertyValue(SearchScope.SUBTREE.name(),null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(5,ldapUserGroupProvider.getGroups().size());
}

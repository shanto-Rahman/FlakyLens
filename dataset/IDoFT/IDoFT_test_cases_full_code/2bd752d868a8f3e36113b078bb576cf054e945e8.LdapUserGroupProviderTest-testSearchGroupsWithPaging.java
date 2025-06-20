@Test public void testSearchGroupsWithPaging() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(null,GROUP_SEARCH_BASE);
  when(configurationContext.getProperty(PROP_GROUP_MEMBER_ATTRIBUTE)).thenReturn(new StandardPropertyValue("member",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_PAGE_SIZE)).thenReturn(new StandardPropertyValue("1",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(5,ldapUserGroupProvider.getGroups().size());
}

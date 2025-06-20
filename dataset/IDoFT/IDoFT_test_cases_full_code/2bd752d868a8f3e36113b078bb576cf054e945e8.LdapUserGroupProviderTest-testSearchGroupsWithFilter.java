@Test public void testSearchGroupsWithFilter() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(null,GROUP_SEARCH_BASE);
  when(configurationContext.getProperty(PROP_GROUP_MEMBER_ATTRIBUTE)).thenReturn(new StandardPropertyValue("member",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_SEARCH_FILTER)).thenReturn(new StandardPropertyValue("(cn=admins)",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  final Set<Group> groups=ldapUserGroupProvider.getGroups();
  assertEquals(1,groups.size());
  assertEquals(1,groups.stream().filter(group -> "cn=admins,ou=groups,o=nifi".equals(group.getName())).count());
}

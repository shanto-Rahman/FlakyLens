@Test public void testSearchUsersAndGroupsMembershipThroughGroupsCaseSensitive() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,GROUP_SEARCH_BASE);
  when(configurationContext.getProperty(PROP_USER_IDENTITY_ATTRIBUTE)).thenReturn(new StandardPropertyValue("uid",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_MEMBER_ATTRIBUTE)).thenReturn(new StandardPropertyValue("member",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_NAME_ATTRIBUTE)).thenReturn(new StandardPropertyValue("cn",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(8,ldapUserGroupProvider.getUsers().size());
  final Set<Group> groups=ldapUserGroupProvider.getGroups();
  assertEquals(5,groups.size());
  final Group team4=groups.stream().filter(group -> "team4".equals(group.getName())).findFirst().orElse(null);
  assertNotNull(team4);
  assertEquals(1,team4.getUsers().size());
  assertEquals(1,team4.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity())).count());
}

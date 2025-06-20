@Test public void testSearchUsersAndGroupsMembershipThroughUsers() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,GROUP_SEARCH_BASE);
  when(configurationContext.getProperty(PROP_USER_IDENTITY_ATTRIBUTE)).thenReturn(new StandardPropertyValue("uid",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_USER_GROUP_ATTRIBUTE)).thenReturn(new StandardPropertyValue("description",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_NAME_ATTRIBUTE)).thenReturn(new StandardPropertyValue("cn",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(8,ldapUserGroupProvider.getUsers().size());
  final Set<Group> groups=ldapUserGroupProvider.getGroups();
  assertEquals(5,groups.size());
  final Group team1=groups.stream().filter(group -> "team1".equals(group.getName())).findFirst().orElse(null);
  assertNotNull(team1);
  assertEquals(2,team1.getUsers().size());
  assertEquals(2,team1.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user4".equals(user.getIdentity()) || "user5".equals(user.getIdentity())).count());
  final Group team2=groups.stream().filter(group -> "team2".equals(group.getName())).findFirst().orElse(null);
  assertNotNull(team2);
  assertEquals(2,team2.getUsers().size());
  assertEquals(2,team2.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user6".equals(user.getIdentity()) || "user7".equals(user.getIdentity())).count());
}

@Test public void testSearchUsersAndGroupsMembershipThroughGroups() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,GROUP_SEARCH_BASE);
  when(configurationContext.getProperty(PROP_USER_IDENTITY_ATTRIBUTE)).thenReturn(new StandardPropertyValue("uid",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_MEMBER_ATTRIBUTE)).thenReturn(new StandardPropertyValue("member",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_NAME_ATTRIBUTE)).thenReturn(new StandardPropertyValue("cn",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(8,ldapUserGroupProvider.getUsers().size());
  final Set<Group> groups=ldapUserGroupProvider.getGroups();
  assertEquals(5,groups.size());
  final Group admins=groups.stream().filter(group -> "admins".equals(group.getName())).findFirst().orElse(null);
  assertNotNull(admins);
  assertEquals(2,admins.getUsers().size());
  assertEquals(2,admins.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity()) || "user3".equals(user.getIdentity())).count());
  final Group readOnly=groups.stream().filter(group -> "read-only".equals(group.getName())).findFirst().orElse(null);
  assertNotNull(readOnly);
  assertEquals(1,readOnly.getUsers().size());
  assertEquals(1,readOnly.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user2".equals(user.getIdentity())).count());
  final Group team1=groups.stream().filter(group -> "team1".equals(group.getName())).findFirst().orElse(null);
  assertNotNull(team1);
  assertEquals(1,team1.getUsers().size());
  assertEquals(1,team1.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity())).count());
  final Group team2=groups.stream().filter(group -> "team2".equals(group.getName())).findFirst().orElse(null);
  assertNotNull(team2);
  assertEquals(1,team2.getUsers().size());
  assertEquals(1,team2.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity())).count());
}

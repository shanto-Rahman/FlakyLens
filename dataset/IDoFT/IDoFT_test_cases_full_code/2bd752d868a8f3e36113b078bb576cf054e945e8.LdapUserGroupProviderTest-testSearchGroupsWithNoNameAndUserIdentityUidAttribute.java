@Test public void testSearchGroupsWithNoNameAndUserIdentityUidAttribute() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(null,GROUP_SEARCH_BASE);
  when(configurationContext.getProperty(PROP_GROUP_MEMBER_ATTRIBUTE)).thenReturn(new StandardPropertyValue("member",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_USER_IDENTITY_ATTRIBUTE)).thenReturn(new StandardPropertyValue("uid",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  final Set<Group> groups=ldapUserGroupProvider.getGroups();
  assertEquals(5,groups.size());
  final Group admins=groups.stream().filter(group -> "cn=admins,ou=groups,o=nifi".equals(group.getName())).findFirst().orElse(null);
  assertNotNull(admins);
  assertFalse(admins.getUsers().isEmpty());
  assertEquals(1,admins.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity())).count());
}

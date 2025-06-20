@Test public void testReferencedUserUsingReferencedAttribute() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration("ou=users-2,o=nifi","ou=groups-2,o=nifi");
  when(configurationContext.getProperty(PROP_USER_IDENTITY_ATTRIBUTE)).thenReturn(new StandardPropertyValue("sn",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_OBJECT_CLASS)).thenReturn(new StandardPropertyValue("room",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_MEMBER_ATTRIBUTE)).thenReturn(new StandardPropertyValue("description",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_NAME_ATTRIBUTE)).thenReturn(new StandardPropertyValue("cn",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_MEMBER_REFERENCED_USER_ATTRIBUTE)).thenReturn(new StandardPropertyValue("uid",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  final Set<Group> groups=ldapUserGroupProvider.getGroups();
  assertEquals(1,groups.size());
  final Group team3=groups.stream().filter(group -> "team3".equals(group.getName())).findFirst().orElse(null);
  assertNotNull(team3);
  assertEquals(1,team3.getUsers().size());
  assertEquals(1,team3.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "User9".equals(user.getIdentity())).count());
}

@Test public void testSearchUsersWithGroupingNoGroupName() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,null);
  when(configurationContext.getProperty(PROP_USER_IDENTITY_ATTRIBUTE)).thenReturn(new StandardPropertyValue("uid",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_USER_GROUP_ATTRIBUTE)).thenReturn(new StandardPropertyValue("description",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(8,ldapUserGroupProvider.getUsers().size());
  assertEquals(3,ldapUserGroupProvider.getGroups().size());
  final UserAndGroups user4AndGroups=ldapUserGroupProvider.getUserAndGroups("user4");
  assertNotNull(user4AndGroups.getUser());
  assertEquals(1,user4AndGroups.getGroups().size());
  assertEquals("cn=team1,ou=groups,o=nifi",user4AndGroups.getGroups().iterator().next().getName());
  final UserAndGroups user7AndGroups=ldapUserGroupProvider.getUserAndGroups("user7");
  assertNotNull(user7AndGroups.getUser());
  assertEquals(1,user7AndGroups.getGroups().size());
  assertEquals("cn=team2,ou=groups,o=nifi",user7AndGroups.getGroups().iterator().next().getName());
  final UserAndGroups user8AndGroups=ldapUserGroupProvider.getUserAndGroups("user8");
  assertNotNull(user8AndGroups.getUser());
  assertEquals(1,user8AndGroups.getGroups().size());
  assertEquals("cn=Team2,ou=groups,o=nifi",user8AndGroups.getGroups().iterator().next().getName());
}

@Test public void testGetGroupByName(){
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,null);
  when(configurationContext.getProperty(PROP_USER_IDENTITY_ATTRIBUTE)).thenReturn(new StandardPropertyValue("uid",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_USER_GROUP_ATTRIBUTE)).thenReturn(new StandardPropertyValue("description",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_NAME_ATTRIBUTE)).thenReturn(new StandardPropertyValue("cn",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(8,ldapUserGroupProvider.getUsers().size());
  assertEquals(2,ldapUserGroupProvider.getGroups().size());
  final Group group=ldapUserGroupProvider.getGroupByName("team1");
  assertNotNull(group);
  assertEquals("team1",group.getName());
}

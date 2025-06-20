@Test public void testUserIdentityAndGroupMappingWithTransforms() throws Exception {
  final Properties props=new Properties();
  props.setProperty("nifi.security.identity.mapping.pattern.dn1","^cn=(.*?),ou=(.*?),o=(.*?)$");
  props.setProperty("nifi.security.identity.mapping.value.dn1","$1");
  props.setProperty("nifi.security.identity.mapping.transform.dn1","UPPER");
  props.setProperty("nifi.security.group.mapping.pattern.dn1","^cn=(.*?),ou=(.*?),o=(.*?)$");
  props.setProperty("nifi.security.group.mapping.value.dn1","$1");
  props.setProperty("nifi.security.group.mapping.transform.dn1","UPPER");
  final NiFiProperties properties=getNiFiProperties(props);
  ldapUserGroupProvider.setNiFiProperties(properties);
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,GROUP_SEARCH_BASE);
  when(configurationContext.getProperty(PROP_USER_SEARCH_FILTER)).thenReturn(new StandardPropertyValue("(uid=user1)",null,ParameterLookup.EMPTY));
  when(configurationContext.getProperty(PROP_GROUP_SEARCH_FILTER)).thenReturn(new StandardPropertyValue("(cn=admins)",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(1,ldapUserGroupProvider.getUsers().size());
  assertNotNull(ldapUserGroupProvider.getUserByIdentity("USER 1"));
  assertEquals(1,ldapUserGroupProvider.getGroups().size());
  assertEquals("ADMINS",ldapUserGroupProvider.getGroups().iterator().next().getName());
}

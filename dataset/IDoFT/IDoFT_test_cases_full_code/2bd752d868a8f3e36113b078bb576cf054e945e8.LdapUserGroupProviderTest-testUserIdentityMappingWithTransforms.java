@Test public void testUserIdentityMappingWithTransforms() throws Exception {
  final Properties props=new Properties();
  props.setProperty("nifi.security.identity.mapping.pattern.dn1","^cn=(.*?),ou=(.*?),o=(.*?)$");
  props.setProperty("nifi.security.identity.mapping.value.dn1","$1");
  props.setProperty("nifi.security.identity.mapping.transform.dn1","UPPER");
  final NiFiProperties properties=getNiFiProperties(props);
  ldapUserGroupProvider.setNiFiProperties(properties);
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,null);
  when(configurationContext.getProperty(PROP_USER_SEARCH_FILTER)).thenReturn(new StandardPropertyValue("(uid=user1)",null,ParameterLookup.EMPTY));
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(1,ldapUserGroupProvider.getUsers().size());
  assertNotNull(ldapUserGroupProvider.getUserByIdentity("USER 1"));
}

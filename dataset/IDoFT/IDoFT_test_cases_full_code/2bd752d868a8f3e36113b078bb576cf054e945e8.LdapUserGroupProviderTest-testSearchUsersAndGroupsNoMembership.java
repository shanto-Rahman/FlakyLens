@Test public void testSearchUsersAndGroupsNoMembership() throws Exception {
  final AuthorizerConfigurationContext configurationContext=getBaseConfiguration(USER_SEARCH_BASE,GROUP_SEARCH_BASE);
  ldapUserGroupProvider.onConfigured(configurationContext);
  assertEquals(8,ldapUserGroupProvider.getUsers().size());
  final Set<Group> groups=ldapUserGroupProvider.getGroups();
  assertEquals(5,groups.size());
  groups.forEach(group -> assertTrue(group.getUsers().isEmpty()));
}

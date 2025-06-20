@Test public void testUserIdentityAndGroupMappingWithTransforms() throws Exception {
assertEquals(1,ldapUserGroupProvider.getUsers().size());
assertNotNull(ldapUserGroupProvider.getUserByIdentity("USER 1"));
assertEquals(1,ldapUserGroupProvider.getGroups().size());
assertEquals("ADMINS",ldapUserGroupProvider.getGroups().iterator().next().getName());
}
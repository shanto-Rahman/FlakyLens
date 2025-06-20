@Test public void testSearchUsersWithNoIdentityAttribute() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertNotNull(ldapUserGroupProvider.getUserByIdentity("cn=User 1,ou=users,o=nifi"));
assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}
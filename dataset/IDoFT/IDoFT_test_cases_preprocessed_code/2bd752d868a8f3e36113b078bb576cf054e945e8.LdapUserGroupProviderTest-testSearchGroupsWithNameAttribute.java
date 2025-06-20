@Test public void testSearchGroupsWithNameAttribute() throws Exception {
assertEquals(5,groups.size());
assertNotNull(admins);
assertFalse(admins.getUsers().isEmpty());
assertEquals(1,admins.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "cn=User 1,ou=users,o=nifi".equals(user.getIdentity())).count());
}
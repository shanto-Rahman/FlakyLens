@Test public void testSearchGroupsWithNameAndUserIdentityCnAttribute() throws Exception {
assertEquals(5,groups.size());
assertNotNull(admins);
assertFalse(admins.getUsers().isEmpty());
assertEquals(1,admins.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "User 1".equals(user.getIdentity())).count());
}
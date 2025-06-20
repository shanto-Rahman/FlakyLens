@Test public void testSearchUsersWithCnIdentityAttribute() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertNotNull(ldapUserGroupProvider.getUserByIdentity("User 1"));
assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}
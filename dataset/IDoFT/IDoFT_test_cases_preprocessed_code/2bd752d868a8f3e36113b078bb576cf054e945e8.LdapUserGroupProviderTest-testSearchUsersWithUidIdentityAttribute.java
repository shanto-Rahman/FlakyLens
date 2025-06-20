@Test public void testSearchUsersWithUidIdentityAttribute() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertNotNull(ldapUserGroupProvider.getUserByIdentity("user1"));
assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}
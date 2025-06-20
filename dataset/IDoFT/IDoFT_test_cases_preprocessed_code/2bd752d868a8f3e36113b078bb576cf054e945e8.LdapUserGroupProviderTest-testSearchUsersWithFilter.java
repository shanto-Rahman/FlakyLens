@Test public void testSearchUsersWithFilter() throws Exception {
assertEquals(1,ldapUserGroupProvider.getUsers().size());
assertNotNull(ldapUserGroupProvider.getUserByIdentity("user1"));
assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}
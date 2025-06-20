@Test public void testSearchUsersSubtreeSearchScope() throws Exception {
assertEquals(9,ldapUserGroupProvider.getUsers().size());
assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}
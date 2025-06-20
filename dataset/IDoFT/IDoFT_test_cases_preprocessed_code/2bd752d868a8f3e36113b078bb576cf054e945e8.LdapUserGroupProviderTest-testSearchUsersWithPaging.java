@Test public void testSearchUsersWithPaging() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertTrue(ldapUserGroupProvider.getGroups().isEmpty());
}
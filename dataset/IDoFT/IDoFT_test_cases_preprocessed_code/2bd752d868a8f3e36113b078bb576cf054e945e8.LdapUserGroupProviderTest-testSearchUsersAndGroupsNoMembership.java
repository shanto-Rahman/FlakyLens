@Test public void testSearchUsersAndGroupsNoMembership() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertEquals(5,groups.size());
groups.forEach(group -> assertTrue(group.getUsers().isEmpty()));
}
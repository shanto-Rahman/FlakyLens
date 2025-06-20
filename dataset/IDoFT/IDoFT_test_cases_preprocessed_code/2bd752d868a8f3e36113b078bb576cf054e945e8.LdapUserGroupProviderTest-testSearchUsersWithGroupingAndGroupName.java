@Test public void testSearchUsersWithGroupingAndGroupName() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertEquals(2,ldapUserGroupProvider.getGroups().size());
assertNotNull(userAndGroups.getUser());
assertEquals(1,userAndGroups.getGroups().size());
assertEquals("team1",userAndGroups.getGroups().iterator().next().getName());
}
@Test public void testSearchUsersAndGroupsMembershipThroughGroupsCaseSensitive() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertEquals(5,groups.size());
assertNotNull(team4);
assertEquals(1,team4.getUsers().size());
assertEquals(1,team4.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity())).count());
}
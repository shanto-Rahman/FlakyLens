@Test public void testSearchUsersAndGroupsMembershipThroughGroupsCaseInsensitive() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertEquals(5,groups.size());
assertNotNull(team4);
assertEquals(2,team4.getUsers().size());
assertEquals(1,team4.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity())).count());
assertEquals(1,team4.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user2".equals(user.getIdentity())).count());
}
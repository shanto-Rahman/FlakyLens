@Test public void testSearchUsersAndGroupsMembershipThroughUsersAndGroups() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertEquals(5,groups.size());
assertNotNull(admins);
assertEquals(2,admins.getUsers().size());
assertEquals(2,admins.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity()) || "user3".equals(user.getIdentity())).count());
assertNotNull(readOnly);
assertEquals(1,readOnly.getUsers().size());
assertEquals(1,readOnly.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user2".equals(user.getIdentity())).count());
assertNotNull(team1);
assertEquals(3,team1.getUsers().size());
assertEquals(3,team1.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity()) || "user4".equals(user.getIdentity()) || "user5".equals(user.getIdentity())).count());
assertNotNull(team2);
assertEquals(3,team2.getUsers().size());
assertEquals(3,team2.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user1".equals(user.getIdentity()) || "user6".equals(user.getIdentity()) || "user7".equals(user.getIdentity())).count());
}
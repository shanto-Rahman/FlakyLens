@Test public void testSearchUsersAndGroupsMembershipThroughUsers() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertEquals(5,groups.size());
assertNotNull(team1);
assertEquals(2,team1.getUsers().size());
assertEquals(2,team1.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user4".equals(user.getIdentity()) || "user5".equals(user.getIdentity())).count());
assertNotNull(team2);
assertEquals(2,team2.getUsers().size());
assertEquals(2,team2.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user6".equals(user.getIdentity()) || "user7".equals(user.getIdentity())).count());
}
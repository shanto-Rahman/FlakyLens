@Test public void testReferencedGroupUsingReferencedAttribute() throws Exception {
assertEquals(1,groups.size());
assertNotNull(team3);
assertEquals(1,team3.getUsers().size());
assertEquals(1,team3.getUsers().stream().map(userIdentifier -> ldapUserGroupProvider.getUser(userIdentifier)).filter(user -> "user9".equals(user.getIdentity())).count());
}
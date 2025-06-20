@Test public void testSearchUsersWithGroupingNoGroupName() throws Exception {
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertEquals(3,ldapUserGroupProvider.getGroups().size());
assertNotNull(user4AndGroups.getUser());
assertEquals(1,user4AndGroups.getGroups().size());
assertEquals("cn=team1,ou=groups,o=nifi",user4AndGroups.getGroups().iterator().next().getName());
assertNotNull(user7AndGroups.getUser());
assertEquals(1,user7AndGroups.getGroups().size());
assertEquals("cn=team2,ou=groups,o=nifi",user7AndGroups.getGroups().iterator().next().getName());
assertNotNull(user8AndGroups.getUser());
assertEquals(1,user8AndGroups.getGroups().size());
assertEquals("cn=Team2,ou=groups,o=nifi",user8AndGroups.getGroups().iterator().next().getName());
}
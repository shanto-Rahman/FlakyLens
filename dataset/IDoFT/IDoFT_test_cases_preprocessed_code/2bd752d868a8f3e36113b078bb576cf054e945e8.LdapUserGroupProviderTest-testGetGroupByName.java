@Test public void testGetGroupByName(){
assertEquals(8,ldapUserGroupProvider.getUsers().size());
assertEquals(2,ldapUserGroupProvider.getGroups().size());
assertNotNull(group);
assertEquals("team1",group.getName());
}
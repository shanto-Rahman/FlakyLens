@Test public void testUserIdentityMapping() throws Exception {
assertEquals(1,ldapUserGroupProvider.getUsers().size());
assertNotNull(ldapUserGroupProvider.getUserByIdentity("User 1,ou=users"));
}
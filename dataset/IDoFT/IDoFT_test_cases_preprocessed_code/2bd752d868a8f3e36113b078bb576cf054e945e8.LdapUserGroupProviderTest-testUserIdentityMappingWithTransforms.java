@Test public void testUserIdentityMappingWithTransforms() throws Exception {
assertEquals(1,ldapUserGroupProvider.getUsers().size());
assertNotNull(ldapUserGroupProvider.getUserByIdentity("USER 1"));
}
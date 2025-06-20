@Test public void testMultipleProvidersWithConflictingUsers() throws Exception {
  final UserGroupProvider userGroupProvider=initCompositeUserGroupProvider(new CompositeUserGroupProvider(),null,null,getUserGroupProviderOne(),getUserGroupProviderTwo(),getConflictingUserGroupProvider());
  Assert.assertEquals(4,userGroupProvider.getUsers().size());
  Assert.assertEquals(2,userGroupProvider.getGroups().size());
  assertNull(userGroupProvider.getUser(NOT_A_REAL_USER_IDENTIFIER));
  assertNull(userGroupProvider.getUserByIdentity(NOT_A_REAL_USER_IDENTITY));
  final UserAndGroups unknownUserAndGroups=userGroupProvider.getUserAndGroups(NOT_A_REAL_USER_IDENTITY);
  assertNotNull(unknownUserAndGroups);
  assertNull(unknownUserAndGroups.getUser());
  assertNull(unknownUserAndGroups.getGroups());
  testUserGroupProviderTwo(userGroupProvider);
  try {
    testUserGroupProviderOne(userGroupProvider);
    assertTrue("Should never get here as we expect the line above to throw an exception",false);
  }
 catch (  Exception e) {
    assertTrue(e instanceof IllegalStateException);
    assertTrue(e.getMessage().contains(USER_1_IDENTITY));
  }
  try {
    testConflictingUserGroupProvider(userGroupProvider);
    assertTrue("Should never get here as we expect the line above to throw an exception",false);
  }
 catch (  Exception e) {
    assertTrue(e instanceof IllegalStateException);
    assertTrue(e.getMessage().contains(USER_1_IDENTITY));
  }
}

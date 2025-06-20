@Test public void testMultipleProvidersWithCollaboratingUserGroupProvider() throws Exception {
Assert.assertEquals(4,userGroupProvider.getUsers().size());
Assert.assertEquals(2,userGroupProvider.getGroups().size());
assertNull(userGroupProvider.getUser(NOT_A_REAL_USER_IDENTIFIER));
assertNull(userGroupProvider.getUserByIdentity(NOT_A_REAL_USER_IDENTITY));
assertNotNull(unknownUserAndGroups);
assertNull(unknownUserAndGroups.getUser());
assertNull(unknownUserAndGroups.getGroups());
assertNotNull(user1AndGroups);
assertNotNull(user1AndGroups.getUser());
Assert.assertEquals(2,user1AndGroups.getGroups().size());
}
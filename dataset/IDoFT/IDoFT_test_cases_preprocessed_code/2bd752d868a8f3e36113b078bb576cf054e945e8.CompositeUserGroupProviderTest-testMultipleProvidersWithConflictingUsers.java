@Test public void testMultipleProvidersWithConflictingUsers() throws Exception {
Assert.assertEquals(4,userGroupProvider.getUsers().size());
Assert.assertEquals(2,userGroupProvider.getGroups().size());
assertNull(userGroupProvider.getUser(NOT_A_REAL_USER_IDENTIFIER));
assertNull(userGroupProvider.getUserByIdentity(NOT_A_REAL_USER_IDENTITY));
assertNotNull(unknownUserAndGroups);
assertNull(unknownUserAndGroups.getUser());
assertNull(unknownUserAndGroups.getGroups());
assertTrue("Should never get here as we expect the line above to throw an exception",false);
assertTrue(e instanceof IllegalStateException);
assertTrue(e.getMessage().contains(USER_1_IDENTITY));
assertTrue("Should never get here as we expect the line above to throw an exception",false);
assertTrue(e instanceof IllegalStateException);
assertTrue(e.getMessage().contains(USER_1_IDENTITY));
}
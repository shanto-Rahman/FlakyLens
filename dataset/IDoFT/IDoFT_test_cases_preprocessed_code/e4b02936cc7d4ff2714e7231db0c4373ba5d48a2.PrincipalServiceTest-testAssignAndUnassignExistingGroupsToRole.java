@Test public void testAssignAndUnassignExistingGroupsToRole() throws Throwable {
assertNotNull(roleState);
assertEquals(superusersRoleLink,roleState.documentSelfLink);
if (ex != null) {
if (ex instanceof ServiceNotFoundException) {
}
}
}
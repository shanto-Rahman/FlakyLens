public void testGetAdminUser() throws Exception {
assertNotNull(user);
assertEquals(user.getName(),ADMIN_USERNAME);
assertTrue(user.isAdmin());
assertFalse(user.isDisabled());
}
public void testGetPlainUser() throws Exception {
assertNotNull(user);
assertEquals(user.getName(),USER_USERNAME);
assertFalse(user.isAdmin());
assertFalse(user.isDisabled());
}
public void testGetPlainUser() throws Exception {
User user=authenticator.getUserForToken(USER_TOKEN);//RW
assertNotNull(user);
assertEquals(user.getName(),USER_USERNAME);
assertFalse(user.isAdmin());
assertFalse(user.isDisabled());
}
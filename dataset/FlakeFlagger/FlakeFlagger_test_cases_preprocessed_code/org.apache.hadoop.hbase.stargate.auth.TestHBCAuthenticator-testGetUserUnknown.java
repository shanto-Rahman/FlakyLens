public void testGetUserUnknown() throws Exception {
User user=authenticator.getUserForToken(UNKNOWN_TOKEN);//RW
assertNull(user);
}
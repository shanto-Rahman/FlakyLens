@Test public void testPromoteUser() throws Exception {
assertTrue(user.getRoles().contains(users.getUserRole()));
assertFalse(user.getRoles().contains(users.getAdminRole()));
assertTrue(user.getRoles().contains(users.getAdminRole()));
assertFalse(user.getRoles().contains(users.getAdminRole()));
}
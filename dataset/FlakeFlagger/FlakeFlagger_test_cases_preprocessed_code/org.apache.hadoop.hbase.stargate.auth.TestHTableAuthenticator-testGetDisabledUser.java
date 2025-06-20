public void testGetDisabledUser() throws Exception {
assertNotNull(user);
assertEquals(user.getName(),DISABLED_USERNAME);
assertFalse(user.isAdmin());
assertTrue(user.isDisabled());
}
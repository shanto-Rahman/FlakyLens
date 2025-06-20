@Test public void testAuthenticate() throws Exception {
assertNull("User alread exists in DB",userDAO.findLdapUserByName("allowedUser"));
assertTrue(result.isAuthenticated());
assertNotNull("User was not created",userDAO.findLdapUserByName("allowedUser"));
assertTrue(result.isAuthenticated());
}
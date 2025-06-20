@Test public void testAuthenticateUserDigestValidInvalid() throws Exception {
Assert.assertFalse("Authenticated",authenticated);
Assert.assertNull("Authentication created",SecurityContextHolder.getContext().getAuthentication());
}
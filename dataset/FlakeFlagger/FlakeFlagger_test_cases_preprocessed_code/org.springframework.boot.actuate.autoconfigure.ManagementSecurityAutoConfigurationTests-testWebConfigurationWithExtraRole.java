@Test public void testWebConfigurationWithExtraRole() throws Exception {
assertTrue(user.getAuthorities().containsAll(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN")));
}
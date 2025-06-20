@Test public void testGetLdapUrls() throws Exception {
assertEquals(INCORRECT_URL_LIST,1,urls.size());
assertEquals(INCORRECT_URL_LIST,"ldap://1.2.3.4:389",urls.get(0));
assertEquals(INCORRECT_URL_LIST,2,urls.size());
assertEquals(INCORRECT_URL_LIST,"ldap://4.3.2.1:1234",urls.get(1));
assertEquals(INCORRECT_URL_LIST,"ldaps://1.2.3.4:389",urls.get(0));
assertEquals(INCORRECT_URL_LIST,"ldaps://4.3.2.1:1234",urls.get(1));
}
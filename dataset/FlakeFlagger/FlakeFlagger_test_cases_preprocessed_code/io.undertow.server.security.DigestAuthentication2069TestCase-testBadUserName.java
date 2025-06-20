/** 
 * Test that a request is correctly rejected with a bad user name. In this case both the supplied username is wrong and also the generated response can not be valid as there is no corresponding user.
 */
@Test public void testBadUserName() throws Exception {
assertEquals(401,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertTrue(value.startsWith(DIGEST.toString()));
assertEquals(REALM_NAME,parsedHeader.get(DigestWWWAuthenticateToken.REALM));
assertEquals(DigestAlgorithm.MD5.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.ALGORITHM));
assertEquals(401,result.getStatusLine().getStatusCode());
}
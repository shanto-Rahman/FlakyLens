/** 
 * Test that a request is correctly rejected if a bad password is used to generate the response value.
 */
@Test public void testBadPassword() throws Exception {
assertEquals(401,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertTrue(value.startsWith(DIGEST.toString()));
assertEquals(REALM_NAME,parsedHeader.get(DigestWWWAuthenticateToken.REALM));
assertEquals(DigestAlgorithm.MD5.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.ALGORITHM));
assertEquals(401,result.getStatusLine().getStatusCode());
}
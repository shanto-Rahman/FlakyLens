/** 
 * Test for a failed authentication where a bad password is provided.
 */
@Test public void testBadPassword() throws Exception {
assertEquals(401,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertTrue(value.startsWith(DIGEST.toString()));
assertEquals(REALM_NAME,parsedHeader.get(DigestWWWAuthenticateToken.REALM));
assertEquals(DigestAlgorithm.MD5.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.ALGORITHM));
assertEquals(DigestQop.AUTH.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.MESSAGE_QOP));
assertNotNull(opaque);
assertEquals(401,result.getStatusLine().getStatusCode());
}
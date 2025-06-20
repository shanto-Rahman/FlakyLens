/** 
 * Test that for a valid username and password if an invalid nonce is used the request should be rejected with the nonce marked as stale, using the replacement nonce should then work.
 */
@Test public void testDifferentNonce() throws Exception {
assertEquals(401,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertTrue(value.startsWith(DIGEST.toString()));
assertEquals(REALM_NAME,parsedHeader.get(DigestWWWAuthenticateToken.REALM));
assertEquals(DigestAlgorithm.MD5.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.ALGORITHM));
assertEquals(401,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertTrue(value.startsWith(DIGEST.toString()));
assertEquals(REALM_NAME,parsedHeader.get(DigestWWWAuthenticateToken.REALM));
assertEquals(DigestAlgorithm.MD5.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.ALGORITHM));
assertEquals("true",parsedHeader.get(DigestWWWAuthenticateToken.STALE));
assertEquals(200,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertEquals("ResponseHandler",values[0].getValue());
}
/** 
 * Test that in RFC2069 mode nonce re-use is rejected.
 */
@Test public void testNonceReUse() throws Exception {
assertEquals(401,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertTrue(value.startsWith(DIGEST.toString()));
assertEquals(REALM_NAME,parsedHeader.get(DigestWWWAuthenticateToken.REALM));
assertEquals(DigestAlgorithm.MD5.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.ALGORITHM));
assertEquals(200,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertEquals("ResponseHandler",values[0].getValue());
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
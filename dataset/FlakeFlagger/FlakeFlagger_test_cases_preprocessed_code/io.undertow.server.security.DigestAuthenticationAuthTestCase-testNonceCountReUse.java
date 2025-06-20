/** 
 * Test for a failed authentication where the nonce count is re-used. Where a nonce count is used the nonce can now be re-used, however each time the nonce count must be different.
 */
@Test public void testNonceCountReUse() throws Exception {
assertEquals(401,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertTrue(value.startsWith(DIGEST.toString()));
assertEquals(REALM_NAME,parsedHeader.get(DigestWWWAuthenticateToken.REALM));
assertEquals(DigestAlgorithm.MD5.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.ALGORITHM));
assertEquals(DigestQop.AUTH.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.MESSAGE_QOP));
assertNotNull(opaque);
if (i == 0) {
assertEquals(200,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertEquals("ResponseHandler",values[0].getValue());
assertEquals(1,values.length);
assertEquals("Didn't expect a new nonce.",nonce,parsedAuthInfo.get(AuthenticationInfoToken.NEXT_NONCE));
assertEquals(DigestQop.AUTH.getToken(),parsedAuthInfo.get(AuthenticationInfoToken.MESSAGE_QOP));
assertEquals(createRspAuth("userOne",REALM_NAME,"passwordOne","/",nonce,nonceCountString,clientNonce),parsedAuthInfo.get(AuthenticationInfoToken.RESPONSE_AUTH));
assertEquals(clientNonce,parsedAuthInfo.get(AuthenticationInfoToken.CNONCE));
assertEquals(nonceCountString,parsedAuthInfo.get(AuthenticationInfoToken.NONCE_COUNT));
assertEquals(401,result.getStatusLine().getStatusCode());
}
}
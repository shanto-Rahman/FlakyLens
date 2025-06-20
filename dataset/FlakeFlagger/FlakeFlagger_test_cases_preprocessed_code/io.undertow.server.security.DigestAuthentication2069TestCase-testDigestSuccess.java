/** 
 * Test for a successful authentication.
 */
@Test public void testDigestSuccess() throws Exception {
assertEquals(401,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertTrue(value.startsWith(DIGEST.toString()));
assertEquals(REALM_NAME,parsedHeader.get(DigestWWWAuthenticateToken.REALM));
assertEquals(DigestAlgorithm.MD5.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.ALGORITHM));
assertFalse(parsedHeader.containsKey(DigestWWWAuthenticateToken.MESSAGE_QOP));
assertEquals(200,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertEquals("ResponseHandler",values[0].getValue());
assertEquals(1,values.length);
assertEquals(200,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertEquals("ResponseHandler",values[0].getValue());
}
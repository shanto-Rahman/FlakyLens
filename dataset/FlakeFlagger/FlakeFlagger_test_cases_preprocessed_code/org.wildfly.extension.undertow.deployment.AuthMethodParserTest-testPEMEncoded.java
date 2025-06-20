/** 
 * Test for checking that auth method parser doesn't decode twice the auth method query parameter
 */
@Test public void testPEMEncoded() throws Exception {
Assert.assertEquals("publicKey = pemOrig; failed probably due https://issues.jboss.org/browse/WFLY-9135",pemOrig,pemDecode);
}
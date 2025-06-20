/** 
 * Verify hostname verifier is set and accepts all
 */
@Test public void verifierAccepts(){
assertNotNull(connection.getHostnameVerifier());
assertTrue(connection.getHostnameVerifier().verify(null,null));
}
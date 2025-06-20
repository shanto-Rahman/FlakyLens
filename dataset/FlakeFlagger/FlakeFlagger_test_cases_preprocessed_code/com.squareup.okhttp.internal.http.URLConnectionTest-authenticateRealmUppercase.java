/** 
 * https://github.com/square/okhttp/issues/342 
 */
@Test public void authenticateRealmUppercase() throws Exception {
assertEquals("Successful auth!",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
}
/** 
 * Ensures the NONE user can delete a connection.
 * @throws Exception ex
 */
@Test public void testNoneUserDeleteConnection() throws Exception {
verifyDelete(helper.getNoneUser(),NONE_CLIENT_ID,403);//RW
}
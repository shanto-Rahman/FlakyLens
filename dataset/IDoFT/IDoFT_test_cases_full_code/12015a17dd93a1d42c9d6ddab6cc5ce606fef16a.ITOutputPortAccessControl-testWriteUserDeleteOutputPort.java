/** 
 * Ensures the WRITE user can delete an Output port.
 * @throws Exception ex
 */
@Test public void testWriteUserDeleteOutputPort() throws Exception {
  verifyDelete(helper.getWriteUser(),AccessControlHelper.WRITE_CLIENT_ID,200);
}

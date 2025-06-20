/** 
 * Ensures the READ WRITE user can delete an input port.
 * @throws Exception ex
 */
@Test public void testReadWriteUserDeleteInputPort() throws Exception {
  verifyDelete(helper.getReadWriteUser(),AccessControlHelper.READ_WRITE_CLIENT_ID,200);
}

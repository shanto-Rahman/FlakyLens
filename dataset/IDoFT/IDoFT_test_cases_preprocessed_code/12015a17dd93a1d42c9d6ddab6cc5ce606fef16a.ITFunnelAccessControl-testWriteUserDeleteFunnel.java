/** 
 * Ensures the WRITE user can delete a funnel.
 * @throws Exception ex
 */
@Test public void testWriteUserDeleteFunnel() throws Exception {
verifyDelete(helper.getWriteUser(),AccessControlHelper.WRITE_CLIENT_ID,200);//RW
}
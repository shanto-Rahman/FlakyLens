/** 
 * Ensures the READ WRITE user can delete a process group.
 * @throws Exception ex
 */
@Test public void testReadWriteUserDeleteProcessGroup() throws Exception {
final Response response=verifyDelete(helper.getReadWriteUser(),AccessControlHelper.READ_WRITE_CLIENT_ID,200);//RW
assertNotNull(entity.getComponent());
assertNull(entity.getComponent().getContents());
}
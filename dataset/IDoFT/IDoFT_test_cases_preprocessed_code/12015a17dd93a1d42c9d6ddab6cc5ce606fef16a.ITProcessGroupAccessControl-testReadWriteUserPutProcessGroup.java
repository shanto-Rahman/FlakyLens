/** 
 * Ensures the READ_WRITE user can put a process group.
 * @throws Exception ex
 */
@Test public void testReadWriteUserPutProcessGroup() throws Exception {
final ProcessGroupEntity entity=getRandomProcessGroup(helper.getReadWriteUser());//RW
assertTrue(entity.getPermissions().getCanRead());
assertTrue(entity.getPermissions().getCanWrite());
assertNotNull(entity.getComponent());
final String updatedName="Updated Name" + count++;//RW
final Response response=updateProcessGroup(helper.getReadWriteUser(),entity);//RW
assertEquals(200,response.getStatus());
assertEquals(READ_WRITE_CLIENT_ID,responseEntity.getRevision().getClientId());
assertEquals(version + 1,responseEntity.getRevision().getVersion().longValue());
assertEquals(updatedName,responseEntity.getComponent().getName());
assertNull(responseEntity.getComponent().getContents());
}
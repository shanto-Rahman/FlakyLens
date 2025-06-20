/** 
 * Ensures the READ_WRITE user can put a process group.
 * @throws Exception ex
 */
@Test public void testReadWriteUserPutProcessGroup() throws Exception {
  final ProcessGroupEntity entity=getRandomProcessGroup(helper.getReadWriteUser());
  assertTrue(entity.getPermissions().getCanRead());
  assertTrue(entity.getPermissions().getCanWrite());
  assertNotNull(entity.getComponent());
  final String updatedName="Updated Name" + count++;
  final long version=entity.getRevision().getVersion();
  entity.getRevision().setClientId(AccessControlHelper.READ_WRITE_CLIENT_ID);
  entity.getComponent().setName(updatedName);
  final Response response=updateProcessGroup(helper.getReadWriteUser(),entity);
  assertEquals(200,response.getStatus());
  final ProcessGroupEntity responseEntity=response.readEntity(ProcessGroupEntity.class);
  assertEquals(READ_WRITE_CLIENT_ID,responseEntity.getRevision().getClientId());
  assertEquals(version + 1,responseEntity.getRevision().getVersion().longValue());
  assertEquals(updatedName,responseEntity.getComponent().getName());
  assertNull(responseEntity.getComponent().getContents());
}

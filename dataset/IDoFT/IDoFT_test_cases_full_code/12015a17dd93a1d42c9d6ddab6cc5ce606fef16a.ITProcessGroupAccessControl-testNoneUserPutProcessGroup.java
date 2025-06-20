/** 
 * Ensures the NONE user cannot put a process group.
 * @throws Exception ex
 */
@Test public void testNoneUserPutProcessGroup() throws Exception {
  final ProcessGroupEntity entity=getRandomProcessGroup(helper.getNoneUser());
  assertFalse(entity.getPermissions().getCanRead());
  assertFalse(entity.getPermissions().getCanWrite());
  assertNull(entity.getComponent());
  final String updatedName="Updated Name" + count++;
  final ProcessGroupDTO requestDto=new ProcessGroupDTO();
  requestDto.setId(entity.getId());
  requestDto.setName(updatedName);
  final long version=entity.getRevision().getVersion();
  final RevisionDTO requestRevision=new RevisionDTO();
  requestRevision.setVersion(version);
  requestRevision.setClientId(AccessControlHelper.NONE_CLIENT_ID);
  final ProcessGroupEntity requestEntity=new ProcessGroupEntity();
  requestEntity.setId(entity.getId());
  requestEntity.setRevision(requestRevision);
  requestEntity.setComponent(requestDto);
  final Response response=updateProcessGroup(helper.getNoneUser(),requestEntity);
  assertEquals(403,response.getStatus());
}

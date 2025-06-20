/** 
 * Ensures the NONE user cannot put a processor.
 * @throws Exception ex
 */
@Test public void testNoneUserPutProcessor() throws Exception {
  final ProcessorEntity entity=getRandomProcessor(helper.getNoneUser());
  assertFalse(entity.getPermissions().getCanRead());
  assertFalse(entity.getPermissions().getCanWrite());
  assertNull(entity.getComponent());
  final String updatedName="Updated Name";
  final ProcessorDTO requestDto=new ProcessorDTO();
  requestDto.setId(entity.getId());
  requestDto.setName(updatedName);
  final long version=entity.getRevision().getVersion();
  final RevisionDTO requestRevision=new RevisionDTO();
  requestRevision.setVersion(version);
  requestRevision.setClientId(AccessControlHelper.NONE_CLIENT_ID);
  final ProcessorEntity requestEntity=new ProcessorEntity();
  requestEntity.setId(entity.getId());
  requestEntity.setRevision(requestRevision);
  requestEntity.setComponent(requestDto);
  final Response response=updateProcessor(helper.getNoneUser(),requestEntity);
  assertEquals(403,response.getStatus());
}

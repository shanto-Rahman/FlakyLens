/** 
 * Ensures the NONE user cannot put a funnel.
 * @throws Exception ex
 */
@Test public void testNoneUserPutFunnel() throws Exception {
  final FunnelEntity entity=getRandomFunnel(helper.getNoneUser());
  assertFalse(entity.getPermissions().getCanRead());
  assertFalse(entity.getPermissions().getCanWrite());
  assertNull(entity.getComponent());
  final FunnelDTO requestDto=new FunnelDTO();
  requestDto.setId(entity.getId());
  requestDto.setPosition(new PositionDTO(0.0,15.0));
  final long version=entity.getRevision().getVersion();
  final RevisionDTO requestRevision=new RevisionDTO();
  requestRevision.setVersion(version);
  requestRevision.setClientId(AccessControlHelper.NONE_CLIENT_ID);
  final FunnelEntity requestEntity=new FunnelEntity();
  requestEntity.setId(entity.getId());
  requestEntity.setRevision(requestRevision);
  requestEntity.setComponent(requestDto);
  final Response response=updateFunnel(helper.getNoneUser(),requestEntity);
  assertEquals(403,response.getStatus());
}

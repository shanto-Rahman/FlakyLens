/** 
 * Ensures the READ user cannot put a processor.
 * @throws Exception ex
 */
@Test public void testReadUserPutProcessGroup() throws Exception {
  final ProcessGroupEntity entity=getRandomProcessGroup(helper.getReadUser());
  assertTrue(entity.getPermissions().getCanRead());
  assertFalse(entity.getPermissions().getCanWrite());
  assertNotNull(entity.getComponent());
  entity.getRevision().setClientId(READ_CLIENT_ID);
  entity.getComponent().setName("Updated Name" + count++);
  final Response response=updateProcessGroup(helper.getReadUser(),entity);
  assertEquals(403,response.getStatus());
}

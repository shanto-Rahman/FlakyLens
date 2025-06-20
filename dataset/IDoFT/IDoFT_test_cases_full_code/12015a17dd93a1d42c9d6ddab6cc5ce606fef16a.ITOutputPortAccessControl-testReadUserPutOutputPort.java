/** 
 * Ensures the READ user cannot put an output port.
 * @throws Exception ex
 */
@Test public void testReadUserPutOutputPort() throws Exception {
  final PortEntity entity=getRandomOutputPort(helper.getReadUser());
  assertTrue(entity.getPermissions().getCanRead());
  assertFalse(entity.getPermissions().getCanWrite());
  assertNotNull(entity.getComponent());
  entity.getRevision().setClientId(READ_CLIENT_ID);
  entity.getComponent().setName("Updated Name" + count++);
  final Response response=updateOutputPort(helper.getReadUser(),entity);
  assertEquals(403,response.getStatus());
}

/** 
 * Ensures the READ WRITE user can get an output port.
 * @throws Exception ex
 */
@Test public void testReadWriteUserGetOutputPort() throws Exception {
  final PortEntity entity=getRandomOutputPort(helper.getReadWriteUser());
  assertTrue(entity.getPermissions().getCanRead());
  assertTrue(entity.getPermissions().getCanWrite());
  assertNotNull(entity.getComponent());
}

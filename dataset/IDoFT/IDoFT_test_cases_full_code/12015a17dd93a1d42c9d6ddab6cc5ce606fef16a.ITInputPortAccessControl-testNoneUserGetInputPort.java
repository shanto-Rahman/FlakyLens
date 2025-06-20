/** 
 * Ensures the NONE user can get an input port.
 * @throws Exception ex
 */
@Test public void testNoneUserGetInputPort() throws Exception {
  final PortEntity entity=getRandomInputPort(helper.getNoneUser());
  assertFalse(entity.getPermissions().getCanRead());
  assertFalse(entity.getPermissions().getCanWrite());
  assertNull(entity.getComponent());
}

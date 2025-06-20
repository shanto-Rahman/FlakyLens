/** 
 * Ensures the READ user can get an output port.
 * @throws Exception ex
 */
@Test public void testReadUserGetOutputPort() throws Exception {
final PortEntity entity=getRandomOutputPort(helper.getReadUser());//RW
assertTrue(entity.getPermissions().getCanRead());
assertFalse(entity.getPermissions().getCanWrite());
assertNotNull(entity.getComponent());
}
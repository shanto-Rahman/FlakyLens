/** 
 * Ensures the READ user can get a connection.
 * @throws Exception ex
 */
@Test public void testReadUserGetConnection() throws Exception {
final ConnectionEntity entity=getRandomConnection(helper.getReadUser());//RW
assertTrue(entity.getPermissions().getCanRead());
assertFalse(entity.getPermissions().getCanWrite());
assertNotNull(entity.getComponent());
}
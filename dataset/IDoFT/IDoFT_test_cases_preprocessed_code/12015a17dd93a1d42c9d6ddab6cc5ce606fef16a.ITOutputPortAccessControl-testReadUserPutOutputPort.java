/** 
 * Ensures the READ user cannot put an output port.
 * @throws Exception ex
 */
@Test public void testReadUserPutOutputPort() throws Exception {
final PortEntity entity=getRandomOutputPort(helper.getReadUser());//RW
assertTrue(entity.getPermissions().getCanRead());
assertFalse(entity.getPermissions().getCanWrite());
assertNotNull(entity.getComponent());
entity.getComponent().setName("Updated Name" + count++);//RW
final Response response=updateOutputPort(helper.getReadUser(),entity);//RW
assertEquals(403,response.getStatus());
}
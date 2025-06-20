/** 
 * Ensures the READ user cannot put a processor.
 * @throws Exception ex
 */
@Test public void testReadUserPutProcessGroup() throws Exception {
final ProcessGroupEntity entity=getRandomProcessGroup(helper.getReadUser());//RW
assertTrue(entity.getPermissions().getCanRead());
assertFalse(entity.getPermissions().getCanWrite());
assertNotNull(entity.getComponent());
entity.getComponent().setName("Updated Name" + count++);//RW
final Response response=updateProcessGroup(helper.getReadUser(),entity);//RW
assertEquals(403,response.getStatus());
}
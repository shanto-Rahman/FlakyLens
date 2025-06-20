/** 
 * Ensures the NONE user cannot put a process group.
 * @throws Exception ex
 */
@Test public void testNoneUserPutProcessGroup() throws Exception {
final ProcessGroupEntity entity=getRandomProcessGroup(helper.getNoneUser());//RW
assertFalse(entity.getPermissions().getCanRead());
assertFalse(entity.getPermissions().getCanWrite());
assertNull(entity.getComponent());
final String updatedName="Updated Name" + count++;//RW
final Response response=updateProcessGroup(helper.getNoneUser(),requestEntity);//RW
assertEquals(403,response.getStatus());
}
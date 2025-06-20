/** 
 * Ensures the NONE user cannot put a processor.
 * @throws Exception ex
 */
@Test public void testNoneUserPutProcessor() throws Exception {
final ProcessorEntity entity=getRandomProcessor(helper.getNoneUser());//RW
assertFalse(entity.getPermissions().getCanRead());
assertFalse(entity.getPermissions().getCanWrite());
assertNull(entity.getComponent());
final Response response=updateProcessor(helper.getNoneUser(),requestEntity);//RW
assertEquals(403,response.getStatus());
}
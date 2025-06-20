/** 
 * Ensures the NONE user cannot put a funnel.
 * @throws Exception ex
 */
@Test public void testNoneUserPutFunnel() throws Exception {
final FunnelEntity entity=getRandomFunnel(helper.getNoneUser());//RW
assertFalse(entity.getPermissions().getCanRead());
assertFalse(entity.getPermissions().getCanWrite());
assertNull(entity.getComponent());
final Response response=updateFunnel(helper.getNoneUser(),requestEntity);//RW
assertEquals(403,response.getStatus());
}
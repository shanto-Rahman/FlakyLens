/** 
 * 新增
 */
@Test public void testInsert(){
Assert.assertEquals(1,mapper.insert(userInfo));
Assert.assertNotNull(userInfo.getId());
Assert.assertEquals(6,(int)userInfo.getId());
Assert.assertNull(userInfo.getEmail());
}
/** 
 * Here we inserting a particular val value and the connection-proxy should alter it _before_ it is inserted.
 */
@Test public void testChangeInsertValue() throws Exception {
ConnectionProxy.lastValue=0;//RW
assertEquals(1,dao.create(foo));
assertEquals(foo.val,ConnectionProxy.lastValue);//RW
assertNotNull(result);
assertEquals(TEST_CHANGE_TO,result.val);
assertTrue(result.val != TEST_CHANGE_FROM);
}
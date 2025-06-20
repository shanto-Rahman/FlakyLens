/** 
 * Here we inserting a particular val value and the connection-proxy should alter it _before_ it is inserted.
 */
@Test public void testChangeInsertValue() throws Exception {
  Dao<Foo,Object> dao=createDao(Foo.class,true);
  Foo foo=new Foo();
  foo.val=TEST_CHANGE_FROM;
  ConnectionProxy.lastValue=0;
  assertEquals(1,dao.create(foo));
  assertEquals(foo.val,ConnectionProxy.lastValue);
  Foo result=dao.queryForId(foo.id);
  assertNotNull(result);
  assertEquals(TEST_CHANGE_TO,result.val);
  assertTrue(result.val != TEST_CHANGE_FROM);
}

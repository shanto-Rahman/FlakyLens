/** 
 * Here we create an instance of  {@link Foo} and then look to see if the connection proxy was able to store the'val' field value.
 */
@Test public void testBasic() throws Exception {
  Dao<Foo,Object> dao=createDao(Foo.class,true);
  Foo foo=new Foo();
  foo.val=100;
  ConnectionProxy.lastValue=0;
  assertEquals(1,dao.create(foo));
  assertEquals(foo.val,ConnectionProxy.lastValue);
}

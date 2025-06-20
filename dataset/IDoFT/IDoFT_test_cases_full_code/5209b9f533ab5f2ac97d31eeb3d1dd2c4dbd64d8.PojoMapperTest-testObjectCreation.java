@Test public void testObjectCreation(){
  PojoMapper<C1> descriptor=new PojoMapper<>(C1.class);
  Object o=new Object();
  Object[] data={"123",o,42};
  C1 object=descriptor.apply(data);
  assertEquals("123",object.a);
  assertSame(o,object.b);
  assertEquals(42,object.c);
}

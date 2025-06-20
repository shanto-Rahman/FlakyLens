@Test public void testSetPathAnnotation(){
  assertEquals("/foo",DummyClass.class.getAnnotation(Path.class).value());
  ReflectionUtils.setAnnotation(DummyClass.class,Path.class,new CustomPath("/bar"));
  assertEquals("/bar",DummyClass.class.getAnnotation(Path.class).value());
}

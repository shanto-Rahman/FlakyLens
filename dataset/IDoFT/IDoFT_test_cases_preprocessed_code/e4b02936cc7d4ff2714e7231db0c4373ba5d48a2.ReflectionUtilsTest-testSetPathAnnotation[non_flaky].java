@Test public void testSetPathAnnotation(){
assertEquals("/foo",DummyClass.class.getAnnotation(Path.class).value());
assertEquals("/bar",DummyClass.class.getAnnotation(Path.class).value());
}
@Test public void testModuleWithContainer(){
assertTrue(c2.started);
assertSame(c2,container.get(Class2.class));
assertNotSame(container.get(Class1.class),container.get(Class1.class));
}
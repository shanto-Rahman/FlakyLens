@Test public void testModule(){
assertNotNull(module.getClasses());
assertEquals(2,module.getClasses().size());
assertTrue(module.getClasses().contains(Class1.class));
assertTrue(module.getClasses().contains(Class2.class));
}
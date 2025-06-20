@Test public void givenAnAbstractClassWithAnAbstractMethodShouldReturnAnInstance(){
  PojoClass pojoClass=PojoClassFactory.getPojoClass(AnAbstractClassWithOneAbstraceMethod.class);
  Assert.assertEquals("Should have 1 constructor and 1 abstract method",2,pojoClass.getPojoMethods().size());
  Class<?> subclass=getSubClass(pojoClass.getClazz());
  assertNotNull(subclass);
  assertIsSubclass(pojoClass.getClazz(),subclass);
}

@Test public void givenTheSameClassShouldReturnSameGeneratedClass(){
  Class<?> clazz=AnAbstractClassWithNoMethods.class;
  Class<?> subClass1=getSubClass(clazz);
  assertIsSubclass(clazz,subClass1);
  Class<?> subClass2=getSubClass(clazz);
  assertIsSubclass(clazz,subClass2);
  Assert.assertEquals("Should generate the same subclass",subClass1,subClass2);
}

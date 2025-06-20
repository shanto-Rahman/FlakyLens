@Test public void givenAnEmptyAbstractClassShouldReturnImplementationClass(){
  Class<?> clazz=AnAbstractClassWithNoMethods.class;
  Class<?> subClassPojoClass=getSubClass(clazz);
  assertNotNull(subClassPojoClass);
  assertIsSubclass(clazz,subClassPojoClass);
}

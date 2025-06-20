@Test public void givenAnAbstractClassWithGenericConstructorShouldConstruct(){
  PojoClass pojoClass=PojoClassFactory.getPojoClass(AnAbstractClassWithGenericConstructor.class);
  Class<?> subClass=getSubClass(pojoClass.getClazz());
  assertIsConcreteAndConstructable(subClass);
}

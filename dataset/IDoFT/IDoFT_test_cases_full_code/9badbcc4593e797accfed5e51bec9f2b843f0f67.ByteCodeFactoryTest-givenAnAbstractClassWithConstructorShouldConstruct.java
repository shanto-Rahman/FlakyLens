@Test public void givenAnAbstractClassWithConstructorShouldConstruct(){
  PojoClass pojoClass=PojoClassFactory.getPojoClass(AnAbstractClassWithConstructor.class);
  Class<?> subClass=getSubClass(pojoClass.getClazz());
  assertIsConcreteAndConstructable(subClass);
}

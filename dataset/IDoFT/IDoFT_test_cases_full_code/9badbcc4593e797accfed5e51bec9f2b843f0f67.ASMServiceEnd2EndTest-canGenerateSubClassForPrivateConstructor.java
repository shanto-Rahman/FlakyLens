@Test public void canGenerateSubClassForPrivateConstructor(){
  final Class<AbstractClassWithPrivateConstructor> type=AbstractClassWithPrivateConstructor.class;
  PojoClass pojoClass=PojoClassFactory.getPojoClass(type);
  AbstractClassWithPrivateConstructor randomInstance=RandomFactory.getRandomValue(type);
  assertThat(randomInstance,notNullValue());
  assertThat(randomInstance.toString(),notNullValue());
}

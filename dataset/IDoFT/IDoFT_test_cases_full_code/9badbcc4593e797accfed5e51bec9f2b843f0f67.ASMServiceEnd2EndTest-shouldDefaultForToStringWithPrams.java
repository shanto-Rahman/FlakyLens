@Test public void shouldDefaultForToStringWithPrams(){
  final Class<AbstractClassWithAbstractNonInheritedToString> type=AbstractClassWithAbstractNonInheritedToString.class;
  PojoClass pojoClass=PojoClassFactory.getPojoClass(type);
  final AbstractClassWithAbstractNonInheritedToString randomValue=RandomFactory.getRandomValue(type);
  assertThat(randomValue,notNullValue());
  assertThat(randomValue.toString(),startsWith(type.getName() + DefaultSubClassDefinition.GENERATED_CLASS_POSTFIX + "@"));
}

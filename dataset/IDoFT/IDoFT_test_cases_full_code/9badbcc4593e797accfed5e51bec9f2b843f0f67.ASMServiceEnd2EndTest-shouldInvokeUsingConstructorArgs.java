@Test public void shouldInvokeUsingConstructorArgs(){
  final Class<AbstractClassWithConstructorArgs> type=AbstractClassWithConstructorArgs.class;
  PojoClass pojoClass=PojoClassFactory.getPojoClass(type);
  assertThat(pojoClass.isAbstract(),is(true));
  assertThat(pojoClass.getPojoConstructors().size(),is(1));
  final List<PojoParameter> constructorParameters=pojoClass.getPojoConstructors().get(0).getPojoParameters();
  assertThat(constructorParameters.size(),is(12));
  int index=0;
  assertType(constructorParameters.get(index++).getType(),String.class);
  assertType(constructorParameters.get(index++).getType(),boolean.class);
  assertType(constructorParameters.get(index++).getType(),byte.class);
  assertType(constructorParameters.get(index++).getType(),char.class);
  assertType(constructorParameters.get(index++).getType(),double.class);
  assertType(constructorParameters.get(index++).getType(),float.class);
  assertType(constructorParameters.get(index++).getType(),int.class);
  assertType(constructorParameters.get(index++).getType(),long.class);
  assertType(constructorParameters.get(index++).getType(),short.class);
  assertType(constructorParameters.get(index++).getType(),int[].class);
  assertType(constructorParameters.get(index++).getType(),String[].class);
  assertType(constructorParameters.get(index).getType(),List.class);
  AbstractClassWithConstructorArgs ap=getRandomValue(type);
  assertThat(ap,notNullValue());
}

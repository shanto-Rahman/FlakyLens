@Test public void implementAbstractToString(){
  final Class<AbstractClassWithAbstractToString> type=AbstractClassWithAbstractToString.class;
  PojoClass pojoClass=PojoClassFactory.getPojoClass(type);
  for (  PojoMethod method : pojoClass.getPojoMethods())   if (method.getName().equals("toString"))   assertThat(method.isAbstract(),is(true));
  AbstractClassWithAbstractToString abstractToString=getRandomValue(type);
  assertThat(abstractToString,notNullValue());
  final String actual=abstractToString.toString();
  final String expected=type.getName() + SubClassDefinition.GENERATED_CLASS_POSTFIX + " [@";
  assertThat(actual,notNullValue());
  assertThat(actual,startsWith(expected));
}

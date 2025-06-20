@Test public void shouldInvokeUsingConstructorArgs(){
assertThat(pojoClass.isAbstract(),is(true));
assertThat(pojoClass.getPojoConstructors().size(),is(1));
assertThat(constructorParameters.size(),is(12));
assertThat(ap,notNullValue());
}
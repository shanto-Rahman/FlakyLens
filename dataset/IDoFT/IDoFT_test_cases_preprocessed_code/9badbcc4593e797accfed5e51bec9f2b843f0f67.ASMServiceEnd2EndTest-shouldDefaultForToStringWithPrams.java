@Test public void shouldDefaultForToStringWithPrams(){
assertThat(randomValue,notNullValue());
assertThat(randomValue.toString(),startsWith(type.getName() + DefaultSubClassDefinition.GENERATED_CLASS_POSTFIX + "@"));
}
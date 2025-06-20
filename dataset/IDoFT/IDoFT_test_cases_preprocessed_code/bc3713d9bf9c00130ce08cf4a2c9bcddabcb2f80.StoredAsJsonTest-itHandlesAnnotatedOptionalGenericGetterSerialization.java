@Test public void itHandlesAnnotatedOptionalGenericGetterSerialization(){
assertThat(Rosetta.getMapper().valueToTree(bean).get("optionalTypeInfoGetter")).isEqualTo(expectedTypeInfo);
}
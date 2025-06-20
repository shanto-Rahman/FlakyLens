@Test public void itHandlesAnnotatedOptionalGenericSetterSerialization(){
assertThat(Rosetta.getMapper().valueToTree(bean).get("optionalTypeInfoSetter")).isEqualTo(expectedTypeInfo);
}
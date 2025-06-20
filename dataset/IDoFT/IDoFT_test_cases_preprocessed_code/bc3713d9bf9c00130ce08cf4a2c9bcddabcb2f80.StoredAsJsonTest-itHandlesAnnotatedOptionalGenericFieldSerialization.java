@Test public void itHandlesAnnotatedOptionalGenericFieldSerialization(){
assertThat(Rosetta.getMapper().valueToTree(bean).get("optionalTypeInfoField")).isEqualTo(expectedTypeInfo);
}
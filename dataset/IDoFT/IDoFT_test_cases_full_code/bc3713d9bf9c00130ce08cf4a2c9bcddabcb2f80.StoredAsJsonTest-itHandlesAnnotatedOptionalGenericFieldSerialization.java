@Test public void itHandlesAnnotatedOptionalGenericFieldSerialization(){
  bean.setOptionalTypeInfoField(Optional.of(typeInfoBean));
  assertThat(Rosetta.getMapper().valueToTree(bean).get("optionalTypeInfoField")).isEqualTo(expectedTypeInfo);
}

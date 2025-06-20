@Test public void itHandlesAnnotatedOptionalGenericSetterSerialization(){
  bean.setOptionalTypeInfoSetter(Optional.of(typeInfoBean));
  assertThat(Rosetta.getMapper().valueToTree(bean).get("optionalTypeInfoSetter")).isEqualTo(expectedTypeInfo);
}

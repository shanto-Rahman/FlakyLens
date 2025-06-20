@Test public void itHandlesAnnotatedOptionalGenericGetterSerialization(){
  bean.setOptionalTypeInfoGetter(Optional.of(typeInfoBean));
  assertThat(Rosetta.getMapper().valueToTree(bean).get("optionalTypeInfoGetter")).isEqualTo(expectedTypeInfo);
}

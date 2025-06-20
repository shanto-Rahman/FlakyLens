@Test public void itHandlesAnnotatedGenericFieldSerialization(){
  bean.setTypeInfoField(typeInfoBean);
  assertThat(Rosetta.getMapper().valueToTree(bean).get("typeInfoField")).isEqualTo(expectedTypeInfo);
}

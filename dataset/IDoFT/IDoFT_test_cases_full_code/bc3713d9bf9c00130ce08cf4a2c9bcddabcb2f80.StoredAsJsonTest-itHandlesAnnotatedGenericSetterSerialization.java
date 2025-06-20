@Test public void itHandlesAnnotatedGenericSetterSerialization(){
  bean.setTypeInfoSetter(typeInfoBean);
  assertThat(Rosetta.getMapper().valueToTree(bean).get("typeInfoSetter")).isEqualTo(expectedTypeInfo);
}

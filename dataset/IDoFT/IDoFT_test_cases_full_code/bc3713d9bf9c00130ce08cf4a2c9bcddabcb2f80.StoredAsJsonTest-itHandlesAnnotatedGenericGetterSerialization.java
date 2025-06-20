@Test public void itHandlesAnnotatedGenericGetterSerialization(){
  bean.setTypeInfoGetter(typeInfoBean);
  assertThat(Rosetta.getMapper().valueToTree(bean).get("typeInfoGetter")).isEqualTo(expectedTypeInfo);
}

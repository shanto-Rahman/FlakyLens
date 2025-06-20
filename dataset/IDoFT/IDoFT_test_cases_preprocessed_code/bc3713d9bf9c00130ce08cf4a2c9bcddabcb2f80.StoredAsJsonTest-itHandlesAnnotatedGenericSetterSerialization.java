@Test public void itHandlesAnnotatedGenericSetterSerialization(){
assertThat(Rosetta.getMapper().valueToTree(bean).get("typeInfoSetter")).isEqualTo(expectedTypeInfo);
}
@Test public void itHandlesAnnotatedGenericGetterSerialization(){
assertThat(Rosetta.getMapper().valueToTree(bean).get("typeInfoGetter")).isEqualTo(expectedTypeInfo);
}
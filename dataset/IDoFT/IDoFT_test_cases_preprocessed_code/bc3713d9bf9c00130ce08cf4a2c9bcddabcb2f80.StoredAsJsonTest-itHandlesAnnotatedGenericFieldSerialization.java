@Test public void itHandlesAnnotatedGenericFieldSerialization(){
assertThat(Rosetta.getMapper().valueToTree(bean).get("typeInfoField")).isEqualTo(expectedTypeInfo);
}
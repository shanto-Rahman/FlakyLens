@Test void objectMapperCustomizerShouldBeApplied() throws Exception {
assertThat(actualHalFormsJson).isEqualTo(expectedHalFormsJson);
}
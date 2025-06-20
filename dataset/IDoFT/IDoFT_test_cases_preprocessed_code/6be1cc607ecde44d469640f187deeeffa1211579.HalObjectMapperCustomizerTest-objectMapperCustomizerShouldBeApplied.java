@Test void objectMapperCustomizerShouldBeApplied() throws Exception {
assertThat(actualHalJson).isEqualTo(expectedHalJson);
}
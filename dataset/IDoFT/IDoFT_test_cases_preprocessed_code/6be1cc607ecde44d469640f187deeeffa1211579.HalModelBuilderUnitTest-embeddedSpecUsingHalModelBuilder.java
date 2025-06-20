@Test void embeddedSpecUsingHalModelBuilder() throws Exception {
assertThat(this.mapper.writeValueAsString(model)).isEqualTo(contextualMapper.readFileContent("hal-embedded-author-illustrator.json"));
}
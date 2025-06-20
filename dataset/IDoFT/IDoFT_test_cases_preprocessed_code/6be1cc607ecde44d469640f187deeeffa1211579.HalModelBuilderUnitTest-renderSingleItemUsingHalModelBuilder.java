@Test void renderSingleItemUsingHalModelBuilder() throws Exception {
assertThat(this.mapper.writeValueAsString(model)).isEqualTo(contextualMapper.readFileContent("hal-single-item.json"));
}
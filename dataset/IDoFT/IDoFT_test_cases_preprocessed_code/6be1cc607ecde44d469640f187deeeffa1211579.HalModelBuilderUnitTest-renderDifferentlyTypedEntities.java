@Test void renderDifferentlyTypedEntities() throws Exception {
assertThat(this.mapper.writeValueAsString(model)).isEqualTo(contextualMapper.readFileContent("hal-multiple-types.json"));
}
@Test void renderExplicitAndImplicitLinkRelations() throws Exception {
assertThat(this.mapper.writeValueAsString(model)).isEqualTo(contextualMapper.readFileContent("hal-explicit-and-implicit-relations.json"));
}
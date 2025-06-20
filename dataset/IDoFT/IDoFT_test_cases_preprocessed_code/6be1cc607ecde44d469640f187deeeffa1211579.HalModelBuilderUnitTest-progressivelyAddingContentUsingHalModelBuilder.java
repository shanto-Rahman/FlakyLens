@Test void progressivelyAddingContentUsingHalModelBuilder() throws JsonProcessingException {
assertThat(this.mapper.writeValueAsString(halModelBuilder.build())).isEqualTo(contextualMapper.readFileContent("hal-empty.json"));
assertThat(this.mapper.writeValueAsString(halModelBuilder.build())).isEqualTo(contextualMapper.readFileContent("hal-one-thing.json"));
assertThat(this.mapper.writeValueAsString(halModelBuilder.build())).isEqualTo(contextualMapper.readFileContent("hal-two-things.json"));
}
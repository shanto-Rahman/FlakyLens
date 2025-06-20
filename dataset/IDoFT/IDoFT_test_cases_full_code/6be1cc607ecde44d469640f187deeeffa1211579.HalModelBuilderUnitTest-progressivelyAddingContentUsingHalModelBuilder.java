@Test void progressivelyAddingContentUsingHalModelBuilder() throws JsonProcessingException {
  HalModelBuilder halModelBuilder=halModel();
  assertThat(this.mapper.writeValueAsString(halModelBuilder.build())).isEqualTo(contextualMapper.readFileContent("hal-empty.json"));
  halModelBuilder.entity(halModel().entity(new Author("Greg L. Turnquist",null,null)).link(Link.of("http://localhost/author/1")).link(Link.of("http://localhost/authors",LinkRelation.of("authors"))).build());
  assertThat(this.mapper.writeValueAsString(halModelBuilder.build())).isEqualTo(contextualMapper.readFileContent("hal-one-thing.json"));
  halModelBuilder.embed(new Product("Alf alarm clock",19.99),LinkRelation.of("product")).build();
  assertThat(this.mapper.writeValueAsString(halModelBuilder.build())).isEqualTo(contextualMapper.readFileContent("hal-two-things.json"));
}

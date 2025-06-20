@Test void previewForLinkRelationsUsingHalModelBuilder() throws Exception {
  RepresentationModel<?> model=halModel().link("/books/the-way-of-zen",IanaLinkRelations.SELF).preview(halModel().entity(new Author("Alan Watts","January 6, 1915","November 16, 1973")).link(ALAN_WATTS_SELF).build()).forLink(Link.of("/people/alan-watts",AUTHOR_REL)).preview(halModel().entity(new Author("John Smith",null,null)).link(JOHN_SMITH_SELF).build()).forLink(Link.of("/people/john-smith",ILLUSTRATOR_REL)).build();
  assertThat(this.mapper.writeValueAsString(model)).isEqualTo(contextualMapper.readFileContent("hal-embedded-author-illustrator.json"));
}

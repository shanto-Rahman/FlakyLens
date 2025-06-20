@Test void embeddedSpecUsingHalModelBuilder() throws Exception {
  RepresentationModel<?> model=halModel().embed(halModel().entity(new Author("Alan Watts","January 6, 1915","November 16, 1973")).link(ALAN_WATTS_SELF).build(),AUTHOR_REL).embed(halModel().entity(new Author("John Smith",null,null)).link(JOHN_SMITH_SELF).build(),ILLUSTRATOR_REL).link(Link.of("/books/the-way-of-zen")).link(Link.of("/people/alan-watts",AUTHOR_REL)).link(Link.of("/people/john-smith",ILLUSTRATOR_REL)).build();
  assertThat(this.mapper.writeValueAsString(model)).isEqualTo(contextualMapper.readFileContent("hal-embedded-author-illustrator.json"));
}

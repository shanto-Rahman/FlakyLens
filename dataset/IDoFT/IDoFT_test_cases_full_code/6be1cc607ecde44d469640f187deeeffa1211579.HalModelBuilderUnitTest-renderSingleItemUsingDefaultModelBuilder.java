@Test void renderSingleItemUsingDefaultModelBuilder() throws Exception {
  RepresentationModel<?> model=halModel().entity(new Author("Alan Watts","January 6, 1915","November 16, 1973")).link(ALAN_WATTS_SELF).build();
  assertThat(this.mapper.writeValueAsString(model)).isEqualTo(contextualMapper.readFileContent("hal-single-item.json"));
}

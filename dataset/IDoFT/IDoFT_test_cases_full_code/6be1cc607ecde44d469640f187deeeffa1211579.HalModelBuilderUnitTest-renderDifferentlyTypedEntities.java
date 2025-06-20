@Test void renderDifferentlyTypedEntities() throws Exception {
  RepresentationModel<?> model=emptyHalModel().embed(new Staff("Frodo Baggins","ring bearer")).embed(new Staff("Bilbo Baggins","burglar")).embed(new Product("ring of power",999.99)).embed(new Product("Saruman's staff",9.99)).link(ALAN_WATTS_SELF).build();
  assertThat(this.mapper.writeValueAsString(model)).isEqualTo(contextualMapper.readFileContent("hal-multiple-types.json"));
}

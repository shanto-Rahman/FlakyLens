@Test void renderExplicitAndImplicitLinkRelations() throws Exception {
  Staff staff1=new Staff("Frodo Baggins","ring bearer");
  Staff staff2=new Staff("Bilbo Baggins","burglar");
  RepresentationModel<?> model=halModel().embed(staff1).embed(staff2).embed(new Product("ring of power",999.99)).embed(new Product("Saruman's staff",9.99)).link(ALAN_WATTS_SELF).embed(staff1,LinkRelation.of("ring bearers")).embed(staff2,LinkRelation.of("burglars")).link(Link.of("/people/frodo-baggins",LinkRelation.of("frodo"))).build();
  assertThat(this.mapper.writeValueAsString(model)).isEqualTo(contextualMapper.readFileContent("hal-explicit-and-implicit-relations.json"));
}

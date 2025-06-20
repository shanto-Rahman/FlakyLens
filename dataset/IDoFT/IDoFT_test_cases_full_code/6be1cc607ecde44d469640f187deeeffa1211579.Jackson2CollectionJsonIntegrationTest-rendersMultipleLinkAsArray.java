@Test void rendersMultipleLinkAsArray(){
  RepresentationModel<?> resourceSupport=new RepresentationModel<>();
  resourceSupport.add(Link.of("localhost"));
  resourceSupport.add(Link.of("localhost2").withRel("orders"));
  assertThat(mapper.writeObject(resourceSupport)).isEqualTo(mapper.readFileContent("resource-support-2.json"));
}

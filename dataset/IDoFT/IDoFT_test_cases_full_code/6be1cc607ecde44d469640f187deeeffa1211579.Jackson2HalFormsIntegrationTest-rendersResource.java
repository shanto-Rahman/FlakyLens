@Test void rendersResource() throws Exception {
  EntityModel<SimplePojo> resource=EntityModel.of(new SimplePojo("test1",1),Link.of("localhost"));
  assertThat(mapper.writeObject(resource)).isEqualTo(mapper.readFileContent("simple-resource-unwrapped.json"));
}

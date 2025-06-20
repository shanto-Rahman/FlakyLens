public void testUnwrappingWithAttribute() throws Exception {
  final String XML="<UnwrappingWithAttributes name=\"Joe\" loc.x=\"15\" loc.y=\"27\"/>";
  ObjectMapper mapper=xmlMapper(false);
  UnwrappingWithAttributes wrapper=mapper.readerFor(UnwrappingWithAttributes.class).readValue(XML);
  assertNotNull(wrapper);
  assertNotNull(wrapper.location);
  assertEquals(15,wrapper.location.x);
  assertEquals(27,wrapper.location.y);
  assertEquals(XML,mapper.writerFor(UnwrappingWithAttributes.class).writeValueAsString(wrapper));
}

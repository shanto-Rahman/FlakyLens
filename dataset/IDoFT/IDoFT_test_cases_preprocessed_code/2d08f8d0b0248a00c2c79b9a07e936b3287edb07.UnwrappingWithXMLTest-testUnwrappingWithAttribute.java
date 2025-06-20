public void testUnwrappingWithAttribute() throws Exception {
assertNotNull(wrapper);
assertNotNull(wrapper.location);
assertEquals(15,wrapper.location.x);
assertEquals(27,wrapper.location.y);
assertEquals(XML,mapper.writerFor(UnwrappingWithAttributes.class).writeValueAsString(wrapper));
}
@Test public void testDeserializeSerializeComplexCompositeTemplate() throws IOException {
assertNull(template.id);
assertNull(template.status);
assertTrue((contentCompose != null) && (!contentCompose.isEmpty()));
}
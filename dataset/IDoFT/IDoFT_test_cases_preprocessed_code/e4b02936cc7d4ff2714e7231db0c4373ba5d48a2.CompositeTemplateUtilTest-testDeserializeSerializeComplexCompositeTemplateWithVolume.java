@Test public void testDeserializeSerializeComplexCompositeTemplateWithVolume() throws IOException {
assertNull(template.id);
assertNull(template.status);
assertTrue((contentCompose != null) && (!contentCompose.isEmpty()));
}
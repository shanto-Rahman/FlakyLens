@Test public void testDeserializeSerializeSimpleDockerComposeWithNetwork() throws IOException {
assertEquals(toUnixLineEnding(expectedContent),toUnixLineEnding(content));
assertNull(template.id);
assertNull(template.status);
assertTrue((contentTemplate != null) && (!contentTemplate.isEmpty()));
}
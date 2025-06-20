@Test public void testDeserializeSerializeSimpleDockerComposeWithNetwork() throws IOException {
  String expectedContent=getContent("docker.simple.network.yaml");
  DockerCompose compose=deserializeDockerCompose(expectedContent);
  String content=serializeDockerCompose(compose);
  assertEquals(toUnixLineEnding(expectedContent),toUnixLineEnding(content));
  CompositeTemplate template=fromDockerComposeToCompositeTemplate(compose);
  assertNull(template.id);
  assertNull(template.status);
  assertComponentTypes(template.components);
  assertContainersComponents(ResourceType.CONTAINER_TYPE.getContentType(),3,template.components);
  assertContainersComponents(ResourceType.NETWORK_TYPE.getContentType(),2,template.components);
  assertContainersComponents(ResourceType.VOLUME_TYPE.getContentType(),0,template.components);
  String contentTemplate=serializeCompositeTemplate(template);
  assertTrue((contentTemplate != null) && (!contentTemplate.isEmpty()));
}

@Test public void testDeserializeSerializeComplexCompositeTemplateWithNetwork() throws IOException {
  String expectedContent=getContent("composite.complex.network.yaml");
  CompositeTemplate template=deserializeCompositeTemplate(expectedContent);
  assertNull(template.id);
  assertNull(template.status);
  assertComponentTypes(template.components);
  assertContainersComponents(ResourceType.CONTAINER_TYPE.getContentType(),3,template.components);
  assertContainersComponents(ResourceType.NETWORK_TYPE.getContentType(),3,template.components);
  String content=serializeCompositeTemplate(template);
  expectedContent=expectedContent.replace("h5-name","h5");
  assertEqualsYamls(toUnixLineEnding(getContent("composite.complex.network.expected.yaml")),toUnixLineEnding(content),true);
  DockerCompose compose=fromCompositeTemplateToDockerCompose(template);
  String contentCompose=serializeDockerCompose(compose);
  assertTrue((contentCompose != null) && (!contentCompose.isEmpty()));
}

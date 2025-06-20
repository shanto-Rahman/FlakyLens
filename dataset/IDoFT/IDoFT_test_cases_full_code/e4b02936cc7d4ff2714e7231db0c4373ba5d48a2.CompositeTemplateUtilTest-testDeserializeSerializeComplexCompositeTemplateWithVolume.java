@Test public void testDeserializeSerializeComplexCompositeTemplateWithVolume() throws IOException {
  String expectedContent=getContent("composite.complex.volume.yaml");
  CompositeTemplate template=deserializeCompositeTemplate(expectedContent);
  assertNull(template.id);
  assertNull(template.status);
  assertComponentTypes(template.components);
  assertContainersComponents(ResourceType.CONTAINER_TYPE.getContentType(),3,template.components);
  assertContainersComponents(ResourceType.NETWORK_TYPE.getContentType(),0,template.components);
  assertContainersComponents(ResourceType.VOLUME_TYPE.getContentType(),3,template.components);
  String content=serializeCompositeTemplate(template);
  assertEqualsYamls(toUnixLineEnding(expectedContent),toUnixLineEnding(content),true);
  DockerCompose compose=fromCompositeTemplateToDockerCompose(template);
  String contentCompose=serializeDockerCompose(compose);
  assertTrue((contentCompose != null) && (!contentCompose.isEmpty()));
}

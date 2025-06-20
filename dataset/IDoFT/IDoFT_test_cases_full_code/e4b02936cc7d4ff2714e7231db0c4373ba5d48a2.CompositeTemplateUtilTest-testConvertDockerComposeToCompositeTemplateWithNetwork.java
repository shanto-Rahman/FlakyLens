@Test public void testConvertDockerComposeToCompositeTemplateWithNetwork() throws IOException {
  CompositeTemplate expectedTemplate=deserializeCompositeTemplate(getContent("composite.simple.network.yaml"));
  String expectedTemplateYaml=serializeCompositeTemplate(expectedTemplate);
  DockerCompose compose1=deserializeDockerCompose(getContent("docker.simple.network.yaml"));
  CompositeTemplate template1=fromDockerComposeToCompositeTemplate(compose1);
  template1.name=expectedTemplate.name;
  assertComponentTypes(template1.components);
  assertContainersComponents(ResourceType.CONTAINER_TYPE.getContentType(),3,template1.components);
  assertContainersComponents(ResourceType.NETWORK_TYPE.getContentType(),2,template1.components);
  assertContainersComponents(ResourceType.VOLUME_TYPE.getContentType(),0,template1.components);
  String template1Yaml=serializeCompositeTemplate(template1);
  assertEqualsYamls(toUnixLineEnding(expectedTemplateYaml),toUnixLineEnding(getContent("composite.simple.network.expected2.yaml")),true);
  assertEqualsYamls(toUnixLineEnding(template1Yaml),toUnixLineEnding(getContent("composite.simple.network.yaml")),true);
  expectedTemplate=deserializeCompositeTemplate(getContent("composite.complex.network.yaml"));
  expectedTemplateYaml=serializeCompositeTemplate(expectedTemplate);
  DockerCompose compose2=deserializeDockerCompose(getContent("docker.complex.network.yaml"));
  CompositeTemplate template2=fromDockerComposeToCompositeTemplate(compose2);
  template2.name=expectedTemplate.name;
  assertComponentTypes(template2.components);
  assertContainersComponents(ResourceType.CONTAINER_TYPE.getContentType(),3,template2.components);
  assertContainersComponents(ResourceType.NETWORK_TYPE.getContentType(),3,template2.components);
  assertContainersComponents(ResourceType.VOLUME_TYPE.getContentType(),0,template2.components);
  String template2Yaml=serializeCompositeTemplate(template2);
  assertEqualsYamls(toUnixLineEnding(getContent("composite.simple.network.expected.yaml")),toUnixLineEnding(template2Yaml),true);
}

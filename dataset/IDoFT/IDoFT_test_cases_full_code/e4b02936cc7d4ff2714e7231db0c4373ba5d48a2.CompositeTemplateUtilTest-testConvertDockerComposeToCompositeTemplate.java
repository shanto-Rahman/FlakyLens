@Test public void testConvertDockerComposeToCompositeTemplate() throws IOException {
  CompositeTemplate expectedTemplate=deserializeCompositeTemplate(getContent("composite.wordpress.yaml"));
  String expectedTemplateYaml=serializeCompositeTemplate(expectedTemplate);
  DockerCompose compose1=deserializeDockerCompose(getContent("docker.wordpress.1.yaml"));
  CompositeTemplate template1=fromDockerComposeToCompositeTemplate(compose1);
  template1.name=expectedTemplate.name;
  assertComponentTypes(template1.components);
  assertContainersComponents(ResourceType.CONTAINER_TYPE.getContentType(),2,template1.components);
  assertContainersComponents(ResourceType.NETWORK_TYPE.getContentType(),0,template1.components);
  assertContainersComponents(ResourceType.VOLUME_TYPE.getContentType(),0,template1.components);
  String template1Yaml=serializeCompositeTemplate(template1);
  assertEqualsYamls(expectedTemplateYaml,template1Yaml,true);
  DockerCompose compose2=deserializeDockerCompose(getContent("docker.wordpress.2.yaml"));
  CompositeTemplate template2=fromDockerComposeToCompositeTemplate(compose2);
  template2.name=expectedTemplate.name;
  assertComponentTypes(template2.components);
  assertContainersComponents(ResourceType.CONTAINER_TYPE.getContentType(),2,template1.components);
  assertContainersComponents(ResourceType.NETWORK_TYPE.getContentType(),0,template1.components);
  assertContainersComponents(ResourceType.VOLUME_TYPE.getContentType(),0,template1.components);
  String template2Yaml=serializeCompositeTemplate(template2);
  assertEqualsYamls(expectedTemplateYaml,template2Yaml,true);
}

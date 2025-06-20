@Test public void testConvertCompositeTemplateToDockerComposeWithNetwork() throws IOException {
  DockerCompose expectedCompose=deserializeDockerCompose(getContent("docker.simple.network.yaml"));
  String expectedComposeYaml=serializeDockerCompose(expectedCompose);
  CompositeTemplate template=deserializeCompositeTemplate(getContent("composite.simple.network.yaml"));
  DockerCompose compose=fromCompositeTemplateToDockerCompose(template);
  String composeYaml=serializeDockerCompose(compose);
  assertEqualsYamls(toUnixLineEnding(expectedComposeYaml),toUnixLineEnding(getContent("docker.simple.network.yaml")));
  assertEqualsYamls(toUnixLineEnding(composeYaml),toUnixLineEnding(getContent("docker.simple.network.expected.yaml")));
  expectedCompose=deserializeDockerCompose(getContent("docker.complex.network.yaml"));
  expectedComposeYaml=serializeDockerCompose(expectedCompose);
  CompositeTemplate template2=deserializeCompositeTemplate(getContent("composite.complex.network.yaml"));
  DockerCompose compose2=fromCompositeTemplateToDockerCompose(template2);
  String compose2Yaml=serializeDockerCompose(compose2);
  assertEqualsYamls(expectedComposeYaml,compose2Yaml);
}

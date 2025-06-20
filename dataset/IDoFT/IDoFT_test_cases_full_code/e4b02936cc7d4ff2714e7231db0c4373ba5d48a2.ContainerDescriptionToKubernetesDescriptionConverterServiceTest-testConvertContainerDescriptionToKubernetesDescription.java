@Test public void testConvertContainerDescriptionToKubernetesDescription() throws Throwable {
  host.log(Level.INFO,"Creating container description.");
  ContainerDescription cd=createContainerDescription(CONTAINER_DESC_NAME);
  cd=doPost(cd,ContainerDescriptionService.FACTORY_LINK);
  host.log(Level.INFO,"Converting...");
  KubernetesDescription kd=doPost(cd,ContainerDescriptionToKubernetesDescriptionConverterService.SELF_LINK,KubernetesDescription.class);
  assertNotNull(kd);
  assertEquals(expectedYamlDefinition,kd.kubernetesEntity);
}

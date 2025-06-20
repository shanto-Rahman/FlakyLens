@Test public void testMapApplicationSuffix() throws IOException {
  String suffix="generate-mcm-10";
  String serviceYaml=serviceYamlFormat.replaceAll("_sufix","");
  String expetedMappedServiceYaml=serviceYamlFormat.replaceAll("_sufix","-" + suffix);
  KubernetesDescription kd=new KubernetesDescription();
  kd.kubernetesEntity=serviceYaml;
  kd=KubernetesUtil.mapApplicationAffix(kd,suffix);
  assertEquals(expetedMappedServiceYaml,kd.kubernetesEntity);
}

@Test public void testApplicationCase() throws ApiException {
KubernetesEnvironmentRepository environmentRepository=new KubernetesEnvironmentRepository(coreApi,kubernetesPropertySourceSuppliers,"default");//RW
assertThat(environment.getPropertySources().size()).isEqualTo(2);
assertThat(propertySource.getName().equals("configmap.application.default") || propertySource.getName().equals("secrets.application.default")).isTrue();
if (propertySource.getName().equals("configmap.application.default")) {
assertThat(propertySource.getSource().size()).isEqualTo(3);
assertThat(propertySource.getSource().get("dummy.property.int2")).isEqualTo(1);
assertThat(propertySource.getSource().get("dummy.property.bool2")).isEqualTo(true);
assertThat(propertySource.getSource().get("dummy.property.string2")).isEqualTo("a");
}
if (propertySource.getName().equals("secrets.application.default")) {
assertThat(propertySource.getSource().size()).isEqualTo(2);
assertThat(propertySource.getSource().get("username")).isEqualTo("user");
assertThat(propertySource.getSource().get("password")).isEqualTo("p455w0rd");
}
}
@Test public void testStoresProfileCase() throws ApiException {
  CoreV1Api coreApi=mock(CoreV1Api.class);
  when(coreApi.listNamespacedConfigMap(eq("default"),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null))).thenReturn(CONFIGMAP_DEFAULT_LIST);
  when(coreApi.listNamespacedSecret(eq("default"),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null))).thenReturn(SECRET_LIST);
  when(coreApi.listNamespacedConfigMap(eq("dev"),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null),eq(null))).thenReturn(CONFIGMAP_DEV_LIST);
  KubernetesEnvironmentRepository environmentRepository=new KubernetesEnvironmentRepository(coreApi,kubernetesPropertySourceSuppliers,"default");
  Environment environment=environmentRepository.findOne("stores","dev","");
  assertThat(environment.getPropertySources().size()).isEqualTo(5);
  environment.getPropertySources().forEach(propertySource -> {
    assertThat(propertySource.getName().equals("configmap.application.default") || propertySource.getName().equals("secrets.application.default") || propertySource.getName().equals("configmap.stores.default")|| propertySource.getName().equals("configmap.stores.dev")|| propertySource.getName().equals("secrets.stores.default")).isTrue();
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
    if (propertySource.getName().equals("configmap.stores.default")) {
      assertThat(propertySource.getSource().size()).isEqualTo(4);
      assertThat(propertySource.getSource().get("dummy.property.int2")).isEqualTo(2);
      assertThat(propertySource.getSource().get("dummy.property.bool2")).isEqualTo(false);
      assertThat(propertySource.getSource().get("dummy.property.string2")).isEqualTo("b");
      assertThat(propertySource.getSource().get("dummy.property.string1")).isEqualTo("a");
    }
    if (propertySource.getName().equals("configmap.stores.dev")) {
      assertThat(propertySource.getSource().size()).isEqualTo(3);
      assertThat(propertySource.getSource().get("dummy.property.int2")).isEqualTo(1);
      assertThat(propertySource.getSource().get("dummy.property.bool2")).isEqualTo(true);
      assertThat(propertySource.getSource().get("dummy.property.string2")).isEqualTo("dev");
    }
    if (propertySource.getName().equals("secrets.stores.default")) {
      assertThat(propertySource.getSource().size()).isEqualTo(2);
      assertThat(propertySource.getSource().get("username")).isEqualTo("stores");
      assertThat(propertySource.getSource().get("password")).isEqualTo("p455w0rd");
    }
  }
);
}

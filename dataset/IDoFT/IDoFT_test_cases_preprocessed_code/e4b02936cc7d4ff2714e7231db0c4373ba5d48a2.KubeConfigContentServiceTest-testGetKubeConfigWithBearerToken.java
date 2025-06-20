@Test public void testGetKubeConfigWithBearerToken() throws Throwable {
assertEquals("attachment; filename=\"kubeconfig\"",o.getResponseHeader("Content-Disposition"));
assertEquals(KUBE_CONFIG_YAML,o.getBody(String.class));
}
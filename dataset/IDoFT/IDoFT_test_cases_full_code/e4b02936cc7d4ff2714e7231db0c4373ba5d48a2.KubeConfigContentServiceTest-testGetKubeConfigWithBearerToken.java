@Test public void testGetKubeConfigWithBearerToken() throws Throwable {
  String authCredentialsLink=createCredentials(AuthCredentialsType.Bearer,true).documentSelfLink;
  String hostLink=createCompute(authCredentialsLink,true,true).documentSelfLink;
  URI serviceUri=UriUtils.buildUri(host,KubeConfigContentService.SELF_LINK,UriUtils.buildUriQuery("hostLink",hostLink));
  verifyOperation(Operation.createGet(serviceUri),o -> {
    assertEquals("attachment; filename=\"kubeconfig\"",o.getResponseHeader("Content-Disposition"));
    assertEquals(KUBE_CONFIG_YAML,o.getBody(String.class));
  }
);
}

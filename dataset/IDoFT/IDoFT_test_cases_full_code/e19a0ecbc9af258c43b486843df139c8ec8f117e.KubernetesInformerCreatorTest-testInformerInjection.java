@Test public void testInformerInjection() throws InterruptedException {
  assertNotNull(podInformer);
  assertNotNull(configMapInformer);
  assertNotNull(podLister);
  assertNotNull(configMapLister);
  V1Pod foo1=new V1Pod().kind("Pod").metadata(new V1ObjectMeta().namespace("default").name("foo1"));
  V1ConfigMap bar1=new V1ConfigMap().kind("ConfigMap").metadata(new V1ObjectMeta().namespace("default").name("bar1"));
  wireMockRule.stubFor(get(urlMatching("^/api/v1/pods.*")).withQueryParam("watch",equalTo("false")).willReturn(aResponse().withStatus(200).withBody(new Gson().toJson(new V1PodList().metadata(new V1ListMeta().resourceVersion("0")).items(Arrays.asList(foo1))))));
  wireMockRule.stubFor(get(urlMatching("^/api/v1/pods.*")).withQueryParam("watch",equalTo("true")).willReturn(aResponse().withStatus(200).withBody("{}")));
  wireMockRule.stubFor(get(urlMatching("^/api/v1/namespaces/default/configmaps.*")).withQueryParam("watch",equalTo("false")).willReturn(aResponse().withStatus(200).withBody(new Gson().toJson(new V1ConfigMapList().metadata(new V1ListMeta().resourceVersion("0")).items(Arrays.asList(bar1))))));
  wireMockRule.stubFor(get(urlMatching("^/api/v1/namespaces/default/configmaps.*")).withQueryParam("watch",equalTo("true")).willReturn(aResponse().withStatus(200).withBody("{}")));
  informerFactory.startAllRegisteredInformers();
  Thread.sleep(200);
  verify(1,getRequestedFor(urlPathEqualTo("/api/v1/pods")).withQueryParam("watch",equalTo("false")));
  verify(getRequestedFor(urlPathEqualTo("/api/v1/pods")).withQueryParam("watch",equalTo("true")));
  verify(1,getRequestedFor(urlPathEqualTo("/api/v1/namespaces/default/configmaps")).withQueryParam("watch",equalTo("false")));
  verify(getRequestedFor(urlPathEqualTo("/api/v1/namespaces/default/configmaps")).withQueryParam("watch",equalTo("true")));
  assertEquals(1,podLister.list().size());
  assertEquals(1,configMapLister.list().size());
}

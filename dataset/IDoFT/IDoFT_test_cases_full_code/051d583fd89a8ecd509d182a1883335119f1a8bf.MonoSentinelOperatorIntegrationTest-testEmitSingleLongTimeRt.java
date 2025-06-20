@Test public void testEmitSingleLongTimeRt(){
  String resourceName=createResourceName("testEmitSingleLongTimeRt");
  StepVerifier.create(Mono.just(2).delayElement(Duration.ofMillis(1000)).map(e -> e * 2).transform(new SentinelReactorTransformer<>(resourceName))).expectNext(4).verifyComplete();
  ClusterNode cn=ClusterBuilderSlot.getClusterNode(resourceName);
  assertNotNull(cn);
  assertEquals(1000,cn.avgRt(),20);
}

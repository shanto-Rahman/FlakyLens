@Test public void testTransformMonoWithSentinelContextEnter(){
  String resourceName=createResourceName("testTransformMonoWithSentinelContextEnter");
  String contextName="test_reactive_context";
  String origin="originA";
  FlowRuleManager.loadRules(Collections.singletonList(new FlowRule(resourceName).setCount(0).setLimitApp(origin).as(FlowRule.class)));
  StepVerifier.create(Mono.just(2).transform(new SentinelReactorTransformer<>(new EntryConfig(resourceName,EntryType.OUT,new ContextConfig(contextName,origin))))).expectError(BlockException.class).verify();
  ClusterNode cn=ClusterBuilderSlot.getClusterNode(resourceName);
  assertNotNull(cn);
  assertEquals(0,cn.passQps(),0.01);
  assertEquals(1,cn.blockRequest());
  assertTrue(Constants.ROOT.getChildList().stream().filter(node -> node instanceof EntranceNode).map(e -> (EntranceNode)e).anyMatch(e -> e.getId().getName().equals(contextName)));
  FlowRuleManager.loadRules(new ArrayList<>());
}

@Test public void testFallBackPrivateMethod() throws Exception {
  assertThat(fooService.fooWithPrivateFallback(1)).isEqualTo("Hello for 1");
  String resourceName="apiFooWithFallback";
  ClusterNode cn=ClusterBuilderSlot.getClusterNode(resourceName);
  try {
    fooService.fooWithPrivateFallback(5758);
    fail("should not reach here");
  }
 catch (  Exception ex) {
    assertThat(cn.exceptionQps()).isZero();
  }
  assertThat(fooService.fooWithPrivateFallback(5763)).isEqualTo("EEE...");
  FlowRuleManager.loadRules(Collections.singletonList(new FlowRule(resourceName).setCount(0)));
  assertThat(fooService.fooWithPrivateFallback(2221)).isEqualTo("Oops, 2221");
}

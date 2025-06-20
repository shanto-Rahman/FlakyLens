@Test public void testInitialState() throws Throwable {
  assertNotNull(manager);
  Map<String,ExtensibilitySubscription> map=getExtensibilitySubscriptions();
  assertNotNull(map);
  assertEquals(0,map.size());
  Map<String,Duration> timeouts=getTimeoutsPerStageAndSubstage();
  assertNotNull(map);
  assertEquals(0,map.size());
}

@Test public void testFilterBasedOnMaxLoadedHost() throws Throwable {
  String firstHost=initialHostLinks.get(0);
  String secondHost=initialHostLinks.get(1);
  String thirdHost=initialHostLinks.get(2);
  Map<String,Long> hostToAvailableMem=new HashMap<>();
  hostToAvailableMem.put(firstHost,6000000000L);
  hostToAvailableMem.put(secondHost,5000000000L);
  hostToAvailableMem.put(thirdHost,7000000000L);
  setHostsStats(hostToAvailableMem);
  updateEpzWithPlacementPolicy();
  filter=new BinpackAffinityHostFilter(host,containerDesc);
  Map<String,HostSelection> selected=filter();
  assertEquals(1,selected.size());
  assertNotNull(selected.get(secondHost));
  hostToAvailableMem.clear();
  hostToAvailableMem.put(firstHost,8000000000L);
  hostToAvailableMem.put(secondHost,16000000000L);
  hostToAvailableMem.put(thirdHost,4000000000L);
  setHostsStats(hostToAvailableMem);
  filter=new BinpackAffinityHostFilter(host,containerDesc);
  selected.clear();
  selected=filter();
  assertEquals(1,selected.size());
  assertNotNull(selected.get(thirdHost));
}

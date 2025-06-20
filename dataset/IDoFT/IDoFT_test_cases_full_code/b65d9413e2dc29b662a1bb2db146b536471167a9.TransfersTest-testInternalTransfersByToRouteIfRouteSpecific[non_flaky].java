@Test public void testInternalTransfersByToRouteIfRouteSpecific(){
  List<Transfer> transfersToStop=sampleFeed.getTransfersToStop("BEATTY_AIRPORT","AB");
  assertEquals(5,transfersToStop.size());
  Set<String> actualIds=new HashSet<>();
  transfersToStop.forEach((route) -> actualIds.add(route.from_route_id));
  Set<String> expectedIds=new HashSet<>(Arrays.asList("AB","FUNNY_BLOCK_AB","STBA","AAMV","ABBFC"));
  assertEquals(expectedIds,actualIds);
}

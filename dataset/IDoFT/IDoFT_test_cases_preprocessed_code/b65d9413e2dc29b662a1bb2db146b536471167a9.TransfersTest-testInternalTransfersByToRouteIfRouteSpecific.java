@Test public void testInternalTransfersByToRouteIfRouteSpecific(){
assertEquals(5,transfersToStop.size());
assertEquals("AB",transfersToStop.get(0).from_route_id);
assertEquals("FUNNY_BLOCK_AB",transfersToStop.get(1).from_route_id);
assertEquals("STBA",transfersToStop.get(2).from_route_id);
assertEquals("AAMV",transfersToStop.get(3).from_route_id);
assertEquals("ABBFC",transfersToStop.get(4).from_route_id);
}
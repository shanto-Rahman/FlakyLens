@Test public void testNoMarker(){
assertFalse(mkt.isStarted());
assertEquals(FilterReply.NEUTRAL,mkt.decide(totoMarker,null,null,null,null,null));
assertEquals(FilterReply.NEUTRAL,mkt.decide(null,null,null,null,null,null));
}
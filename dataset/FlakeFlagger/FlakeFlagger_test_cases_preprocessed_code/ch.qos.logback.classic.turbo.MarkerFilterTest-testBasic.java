@Test public void testBasic(){
mkt.setMarker(TOTO);//RW
assertTrue(mkt.isStarted());
assertEquals(FilterReply.DENY,mkt.decide(null,null,null,null,null,null));
assertEquals(FilterReply.ACCEPT,mkt.decide(totoMarker,null,null,null,null,null));
}
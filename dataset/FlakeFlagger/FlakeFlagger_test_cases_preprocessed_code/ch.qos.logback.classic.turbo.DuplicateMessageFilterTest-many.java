@Test public void many(){
assertEquals(FilterReply.NEUTRAL,dmf.decide(null,null,null,"a" + i,null,null));
assertEquals(FilterReply.DENY,dmf.decide(null,null,null,"a" + i,null,null));
assertEquals(FilterReply.NEUTRAL,dmf.decide(null,null,null,"a" + i,null,null));
}
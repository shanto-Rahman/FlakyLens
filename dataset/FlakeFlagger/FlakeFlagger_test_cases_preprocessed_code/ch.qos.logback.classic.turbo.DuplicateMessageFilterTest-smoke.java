@Test public void smoke(){
assertEquals(FilterReply.NEUTRAL,dmf.decide(null,null,null,"x",null,null));
assertEquals(FilterReply.NEUTRAL,dmf.decide(null,null,null,"y",null,null));
assertEquals(FilterReply.DENY,dmf.decide(null,null,null,"x",null,null));
assertEquals(FilterReply.DENY,dmf.decide(null,null,null,"y",null,null));
}
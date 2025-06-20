@Test public void memoryLoss(){
assertEquals(FilterReply.NEUTRAL,dmf.decide(null,null,null,"a",null,null));
assertEquals(FilterReply.NEUTRAL,dmf.decide(null,null,null,"b",null,null));
assertEquals(FilterReply.NEUTRAL,dmf.decide(null,null,null,"a",null,null));
}
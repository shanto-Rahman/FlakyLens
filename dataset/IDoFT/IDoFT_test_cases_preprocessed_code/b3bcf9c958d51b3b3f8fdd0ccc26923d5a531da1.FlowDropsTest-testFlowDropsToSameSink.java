@Test public void testFlowDropsToSameSink(){
assertEquals(2,counter.getCount());
assertEquals(0,yawp(Work.class).ids().size());
}
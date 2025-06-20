@Test public void indicatorExists(){
assertEquals(1,this.context.getBeanNamesForType(SolrServer.class).length);
assertNotNull(healthIndicator);
}
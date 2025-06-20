@Test public void solrHeathIndicator(){
assertEquals(1,beans.size());
assertEquals(SolrHealthIndicator.class,beans.values().iterator().next().getClass());
}
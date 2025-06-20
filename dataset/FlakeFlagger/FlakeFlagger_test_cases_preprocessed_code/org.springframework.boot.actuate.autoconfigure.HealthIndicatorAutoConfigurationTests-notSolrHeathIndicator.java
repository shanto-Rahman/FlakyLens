@Test public void notSolrHeathIndicator(){
assertEquals(1,beans.size());
assertEquals(ApplicationHealthIndicator.class,beans.values().iterator().next().getClass());
}
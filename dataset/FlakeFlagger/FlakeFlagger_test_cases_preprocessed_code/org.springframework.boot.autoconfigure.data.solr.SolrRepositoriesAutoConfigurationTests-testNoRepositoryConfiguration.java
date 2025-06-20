@Test public void testNoRepositoryConfiguration(){
assertThat(this.context.getBean(SolrServer.class),instanceOf(HttpSolrServer.class));
}
@Test public void templateExists(){
assertEquals(1,this.context.getBeanNamesForType(ElasticsearchTemplate.class).length);
}
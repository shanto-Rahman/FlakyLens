@Test public void templateExists(){
assertEquals(1,this.context.getBeanNamesForType(MongoTemplate.class).length);
}
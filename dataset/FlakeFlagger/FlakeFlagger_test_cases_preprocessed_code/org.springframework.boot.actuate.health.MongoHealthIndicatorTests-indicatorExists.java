@Test public void indicatorExists(){
assertEquals(1,this.context.getBeanNamesForType(MongoTemplate.class).length);
assertNotNull(healthIndicator);
}
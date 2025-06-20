@Test public void indicatorExists(){
assertEquals(1,this.context.getBeanNamesForType(RabbitAdmin.class).length);
assertNotNull(healthIndicator);
}
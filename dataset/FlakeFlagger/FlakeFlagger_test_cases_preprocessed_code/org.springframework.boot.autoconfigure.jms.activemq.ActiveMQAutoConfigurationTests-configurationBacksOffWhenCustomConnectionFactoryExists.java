@Test public void configurationBacksOffWhenCustomConnectionFactoryExists(){
assertTrue(mockingDetails(this.context.getBean(ConnectionFactory.class)).isMock());
}
@Test public void testArrayPropertiesBinding(){
assertEquals(1,this.context.getBeanNamesForType(TestProperties.class).length);
assertEquals(3,this.context.getBean(TestProperties.class).getArray().length);
}
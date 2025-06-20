@Test public void testSystemPropertiesBinding(){
assertEquals(1,this.context.getBeanNamesForType(TestProperties.class).length);
assertEquals("foo",this.context.getBean(TestProperties.class).name);
}
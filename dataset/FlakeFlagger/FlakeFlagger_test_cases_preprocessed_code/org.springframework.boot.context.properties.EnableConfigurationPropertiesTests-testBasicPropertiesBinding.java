@Test public void testBasicPropertiesBinding(){
assertEquals(1,this.context.getBeanNamesForType(TestProperties.class).length);
assertEquals("foo",this.context.getBean(TestProperties.class).name);
}
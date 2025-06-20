@Test public void testPropertiesEmbeddedBinding(){
assertEquals(1,this.context.getBeanNamesForType(EmbeddedTestProperties.class).length);
assertEquals("foo",this.context.getBean(TestProperties.class).name);
}
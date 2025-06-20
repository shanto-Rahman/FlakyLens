@Test public void testBindingDirectlyToFileResolvedFromEnvironment(){
assertEquals(1,this.context.getBeanNamesForType(ResourceBindingProperties.class).length);
assertEquals("other",this.context.getBean(ResourceBindingProperties.class).name);
}
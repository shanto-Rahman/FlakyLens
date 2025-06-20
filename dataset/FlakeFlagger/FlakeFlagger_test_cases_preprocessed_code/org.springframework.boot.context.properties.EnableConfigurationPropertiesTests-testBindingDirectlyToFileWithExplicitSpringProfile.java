@Test public void testBindingDirectlyToFileWithExplicitSpringProfile(){
assertEquals(1,this.context.getBeanNamesForType(ResourceBindingProperties.class).length);
assertEquals("bar",this.context.getBean(ResourceBindingProperties.class).name);
}
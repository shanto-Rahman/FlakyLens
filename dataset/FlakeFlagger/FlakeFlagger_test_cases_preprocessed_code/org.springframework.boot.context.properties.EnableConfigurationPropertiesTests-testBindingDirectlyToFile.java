@Test public void testBindingDirectlyToFile(){
assertEquals(1,this.context.getBeanNamesForType(ResourceBindingProperties.class).length);
assertEquals("foo",this.context.getBean(ResourceBindingProperties.class).name);
}
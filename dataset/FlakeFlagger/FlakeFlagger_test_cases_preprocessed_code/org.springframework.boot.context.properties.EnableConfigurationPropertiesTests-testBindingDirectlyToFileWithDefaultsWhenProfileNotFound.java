@Test public void testBindingDirectlyToFileWithDefaultsWhenProfileNotFound(){
assertEquals(1,this.context.getBeanNamesForType(ResourceBindingProperties.class).length);
assertEquals("foo",this.context.getBean(ResourceBindingProperties.class).name);
}
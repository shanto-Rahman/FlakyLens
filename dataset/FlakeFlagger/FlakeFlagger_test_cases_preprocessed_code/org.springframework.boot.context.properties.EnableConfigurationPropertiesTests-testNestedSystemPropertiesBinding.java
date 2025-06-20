@Test public void testNestedSystemPropertiesBinding(){
assertEquals(1,this.context.getBeanNamesForType(NestedProperties.class).length);
assertEquals("foo",this.context.getBean(NestedProperties.class).name);
assertEquals("bar",this.context.getBean(NestedProperties.class).nested.name);
}
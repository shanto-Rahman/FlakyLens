@Test public void testBindingOnlyParentContext(){
assertEquals(0,this.context.getBeanNamesForType(TestProperties.class).length);
assertEquals(1,parent.getBeanNamesForType(TestProperties.class).length);
assertEquals("foo",this.context.getBean(TestConsumer.class).getName());
}
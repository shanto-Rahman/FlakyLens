@Test public void testBindingDirectlyToFileWithTwoExplicitSpringProfiles(){
assertEquals(1,this.context.getBeanNamesForType(ResourceBindingProperties.class).length);
assertEquals("spam",this.context.getBean(ResourceBindingProperties.class).name);
}
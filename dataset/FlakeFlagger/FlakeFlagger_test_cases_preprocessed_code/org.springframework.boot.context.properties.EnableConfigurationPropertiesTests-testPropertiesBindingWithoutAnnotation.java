@Test public void testPropertiesBindingWithoutAnnotation(){
assertEquals(1,this.context.getBeanNamesForType(MoreProperties.class).length);
assertEquals("foo",this.context.getBean(MoreProperties.class).name);
}
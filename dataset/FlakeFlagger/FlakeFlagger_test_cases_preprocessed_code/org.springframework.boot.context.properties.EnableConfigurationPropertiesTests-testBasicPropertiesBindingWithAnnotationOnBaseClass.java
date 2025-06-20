@Test public void testBasicPropertiesBindingWithAnnotationOnBaseClass(){
assertEquals(1,this.context.getBeanNamesForType(DerivedProperties.class).length);
assertEquals("foo",this.context.getBean(BaseProperties.class).name);
}
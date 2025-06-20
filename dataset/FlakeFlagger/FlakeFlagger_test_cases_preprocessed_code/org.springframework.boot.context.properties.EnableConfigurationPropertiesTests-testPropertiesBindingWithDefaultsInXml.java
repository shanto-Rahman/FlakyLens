@Test public void testPropertiesBindingWithDefaultsInXml(){
assertEquals("Wrong beans: " + Arrays.asList(beanNames),1,beanNames.length);
assertEquals("bar",this.context.getBean(TestProperties.class).name);
}
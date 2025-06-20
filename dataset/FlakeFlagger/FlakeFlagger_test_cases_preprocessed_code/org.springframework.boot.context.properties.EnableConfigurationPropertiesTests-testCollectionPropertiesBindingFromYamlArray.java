@Test public void testCollectionPropertiesBindingFromYamlArray(){
assertEquals(2,this.context.getBean(TestProperties.class).getList().size());
}
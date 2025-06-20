@Test public void testIgnoreNestedPropertiesBinding(){
assertEquals(1,this.context.getBeanNamesForType(IgnoreNestedTestProperties.class).length);
assertEquals("foo",this.context.getBean(TestProperties.class).name);
}
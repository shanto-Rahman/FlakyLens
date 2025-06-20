@Test public void testStrictPropertiesBinding(){
assertEquals(1,this.context.getBeanNamesForType(StrictTestProperties.class).length);
assertEquals("foo",this.context.getBean(TestProperties.class).name);
}
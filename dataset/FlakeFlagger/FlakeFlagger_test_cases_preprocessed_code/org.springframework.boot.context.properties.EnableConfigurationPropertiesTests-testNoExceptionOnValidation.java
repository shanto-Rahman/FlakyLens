@Test public void testNoExceptionOnValidation(){
assertEquals(1,this.context.getBeanNamesForType(NoExceptionIfInvalidTestProperties.class).length);
assertEquals("foo",this.context.getBean(TestProperties.class).name);
}
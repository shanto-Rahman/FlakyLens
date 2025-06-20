@Test public void testAnnotatedBean(){
assertEquals("foo",this.context.getBean(External.class).getName());
}
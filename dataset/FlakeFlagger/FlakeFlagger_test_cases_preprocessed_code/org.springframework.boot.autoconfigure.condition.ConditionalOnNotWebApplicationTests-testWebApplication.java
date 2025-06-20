@Test public void testWebApplication(){
assertTrue(this.context.containsBean("foo"));
assertEquals("foo",this.context.getBean("foo"));
}
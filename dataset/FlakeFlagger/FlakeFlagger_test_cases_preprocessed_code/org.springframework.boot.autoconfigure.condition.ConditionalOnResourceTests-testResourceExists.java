@Test public void testResourceExists(){
assertTrue(this.context.containsBean("foo"));
assertEquals("foo",this.context.getBean("foo"));
}
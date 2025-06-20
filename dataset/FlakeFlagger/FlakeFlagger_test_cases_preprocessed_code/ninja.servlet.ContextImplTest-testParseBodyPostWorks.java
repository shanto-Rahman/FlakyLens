@Test public void testParseBodyPostWorks(){
assertTrue(o instanceof Dummy);
assertTrue(o.name.equals(dummy.name));
assertTrue(o.count.equals(dummy.count));
}
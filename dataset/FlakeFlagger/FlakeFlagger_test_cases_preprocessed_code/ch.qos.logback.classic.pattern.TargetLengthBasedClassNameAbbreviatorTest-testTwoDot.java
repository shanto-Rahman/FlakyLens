@Test public void testTwoDot(){
assertEquals("c.l.Foobar",abbreviator.abbreviate(name));
assertEquals("c.l.Foobar",abbreviator.abbreviate(name));
assertEquals("c..Foobar",abbreviator.abbreviate(name));
assertEquals("..Foobar",abbreviator.abbreviate(name));
}
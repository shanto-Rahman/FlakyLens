@Test public void test3Dot(){
assertEquals("c.l.x.Foobar",abbreviator.abbreviate(name));
assertEquals("c.l.x.Foobar",abbreviator.abbreviate(name));
assertEquals("c.l.xyz.Foobar",abbreviator.abbreviate(name));
assertEquals("c.l.a.Foobar",abbreviator.abbreviate(name));
}
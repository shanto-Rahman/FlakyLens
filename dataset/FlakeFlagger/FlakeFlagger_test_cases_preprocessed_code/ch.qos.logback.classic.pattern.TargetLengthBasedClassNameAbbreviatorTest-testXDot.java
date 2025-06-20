@Test public void testXDot(){
assertEquals("c.l.w.a.Foobar",abbreviator.abbreviate(name));
assertEquals("c.l.w.alligator.Foobar",abbreviator.abbreviate(name));
assertEquals("c.l.w.a.t.Foobar",abbreviator.abbreviate(name));
assertEquals("c.l.w.a.tomato.Foobar",abbreviator.abbreviate(name));
assertEquals("c.l.w.alligator.tomato.Foobar",abbreviator.abbreviate(name));
}
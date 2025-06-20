@Test public void testOneDot(){
assertEquals("h.world",abbreviator.abbreviate(name));
assertEquals("h.world",abbreviator.abbreviate(name));
assertEquals(".world",abbreviator.abbreviate(name));
}
@Test public void testDetachWithMissingContext(){
assertEquals("tata",selector.getLoggerContext().getName());
assertEquals("titi",selector.getLoggerContext().getName());
assertEquals(2,selector.getCount());
}
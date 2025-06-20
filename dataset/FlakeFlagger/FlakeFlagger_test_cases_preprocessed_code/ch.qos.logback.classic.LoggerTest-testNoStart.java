@Test public void testNoStart(){
assertEquals(Status.WARN,s0.getLevel());
assertTrue(s0.getMessage().startsWith("Attempted to append to non started"));
}
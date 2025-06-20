@Test public void secure(){
assertTrue(result instanceof Health);
assertTrue(((Health)result).getStatus() == Status.UP);
assertEquals("bar",((Health)result).getDetails().get("foo"));
}
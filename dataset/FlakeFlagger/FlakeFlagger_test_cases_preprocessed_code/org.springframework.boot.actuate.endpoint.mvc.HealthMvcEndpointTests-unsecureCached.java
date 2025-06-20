@Test public void unsecureCached(){
assertTrue(result instanceof Health);
assertTrue(((Health)result).getStatus() == Status.UP);
assertTrue(health.getStatus() == Status.UP);
}
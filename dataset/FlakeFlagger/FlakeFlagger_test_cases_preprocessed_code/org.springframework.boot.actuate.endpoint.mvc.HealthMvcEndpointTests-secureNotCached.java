@Test public void secureNotCached(){
assertTrue(result instanceof Health);
assertTrue(((Health)result).getStatus() == Status.UP);
assertTrue(health.getStatus() == Status.DOWN);
}
@Test public void up(){
assertTrue(result instanceof Health);
assertTrue(((Health)result).getStatus() == Status.UP);
}
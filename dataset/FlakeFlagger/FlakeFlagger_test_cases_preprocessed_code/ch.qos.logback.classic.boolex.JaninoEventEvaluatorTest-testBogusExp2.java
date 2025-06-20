@Test public void testBogusExp2(){
assertTrue(jee.isStarted());
fail("should throw an exception");
assertFalse(jee.isStarted());
}
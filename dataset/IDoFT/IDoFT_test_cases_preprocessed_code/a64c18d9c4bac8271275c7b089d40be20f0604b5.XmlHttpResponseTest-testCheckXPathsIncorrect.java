@Test public void testCheckXPathsIncorrect(){
assertEquals("NOK",checkResult.getResult());
assertEquals(expected,checkResult.getMismatchDetail());
}
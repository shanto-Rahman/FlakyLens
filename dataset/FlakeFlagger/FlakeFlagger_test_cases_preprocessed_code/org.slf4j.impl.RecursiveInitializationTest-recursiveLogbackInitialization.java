@Test public void recursiveLogbackInitialization(){
assertEquals("Was expecting no errors",Status.WARN,statusChecker.getHighestLevel(0));
}
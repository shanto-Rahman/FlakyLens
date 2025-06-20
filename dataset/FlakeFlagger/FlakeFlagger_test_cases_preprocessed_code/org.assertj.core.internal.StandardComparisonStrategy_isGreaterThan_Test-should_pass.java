@Test public void should_pass(){
assertTrue(standardComparisonStrategy.isGreaterThan(boss,young));
assertFalse(standardComparisonStrategy.isGreaterThan(young,boss));
assertFalse(standardComparisonStrategy.isGreaterThan(boss,boss));
}
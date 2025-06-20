@Test public void should_pass(){
assertTrue(standardComparisonStrategy.isLessThan(young,boss));
assertFalse(standardComparisonStrategy.isLessThan(boss,young));
assertFalse(standardComparisonStrategy.isLessThan(boss,boss));
}
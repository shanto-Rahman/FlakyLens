@Test public void should_pass(){
assertTrue(standardComparisonStrategy.isGreaterThanOrEqualTo(boss,young));
assertTrue(standardComparisonStrategy.isGreaterThanOrEqualTo(boss,boss));
assertFalse(standardComparisonStrategy.isGreaterThanOrEqualTo(young,boss));
}
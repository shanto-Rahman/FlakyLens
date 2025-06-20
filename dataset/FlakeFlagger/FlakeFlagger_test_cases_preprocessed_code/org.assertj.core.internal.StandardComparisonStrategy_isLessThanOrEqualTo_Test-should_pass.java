@Test public void should_pass(){
assertTrue(standardComparisonStrategy.isLessThanOrEqualTo(young,boss));
assertFalse(standardComparisonStrategy.isLessThanOrEqualTo(boss,young));
assertTrue(standardComparisonStrategy.isLessThanOrEqualTo(boss,boss));
}
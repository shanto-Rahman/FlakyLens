@Test public void should_pass(){
assertTrue(caseInsensitiveComparisonStrategy.isLessThan(string,greaterString));
assertFalse(caseInsensitiveComparisonStrategy.isLessThan(greaterString,string));
assertFalse(caseInsensitiveComparisonStrategy.isLessThan(string,string));
assertFalse(caseInsensitiveComparisonStrategy.isLessThan(string,"STRING"));
assertTrue(caseInsensitiveComparisonStrategy.isLessThan(string,lowerString));
assertFalse(caseInsensitiveComparisonStrategy.isLessThan(lowerString,string));
}
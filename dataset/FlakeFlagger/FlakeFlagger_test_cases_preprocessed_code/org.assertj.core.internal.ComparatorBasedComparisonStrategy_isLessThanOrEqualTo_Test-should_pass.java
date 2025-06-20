@Test public void should_pass(){
assertTrue(caseInsensitiveComparisonStrategy.isLessThanOrEqualTo(string,greaterString));
assertTrue(caseInsensitiveComparisonStrategy.isLessThanOrEqualTo(string,"STRING"));
assertTrue(caseInsensitiveComparisonStrategy.isLessThanOrEqualTo(string,string));
assertFalse(caseInsensitiveComparisonStrategy.isLessThanOrEqualTo(greaterString,string));
assertTrue(caseInsensitiveComparisonStrategy.isLessThanOrEqualTo(string,lowerString));
assertFalse(caseInsensitiveComparisonStrategy.isLessThanOrEqualTo(lowerString,string));
}
@Test public void should_pass(){
assertTrue(caseInsensitiveComparisonStrategy.isGreaterThan(string,lesserUpperString));
assertFalse(caseInsensitiveComparisonStrategy.isGreaterThan(lesserUpperString,string));
assertFalse(caseInsensitiveComparisonStrategy.isGreaterThan(string,string));
assertFalse(caseInsensitiveComparisonStrategy.isGreaterThan(string,"STRINGA"));
assertTrue(caseInsensitiveComparisonStrategy.isGreaterThan(string,lowerLesserString));
assertFalse(caseInsensitiveComparisonStrategy.isGreaterThan(lowerLesserString,string));
}
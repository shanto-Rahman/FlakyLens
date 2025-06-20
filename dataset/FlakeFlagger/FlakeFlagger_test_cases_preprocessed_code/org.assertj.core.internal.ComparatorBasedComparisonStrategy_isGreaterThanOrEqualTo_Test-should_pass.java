@Test public void should_pass(){
assertTrue(caseInsensitiveComparisonStrategy.isGreaterThanOrEqualTo(string,string));
assertTrue(caseInsensitiveComparisonStrategy.isGreaterThanOrEqualTo(string,"STRINGA"));
assertTrue(caseInsensitiveComparisonStrategy.isGreaterThanOrEqualTo(string,lesserUpperString));
assertFalse(caseInsensitiveComparisonStrategy.isGreaterThanOrEqualTo(lesserUpperString,string));
assertTrue(caseInsensitiveComparisonStrategy.isGreaterThanOrEqualTo(string,lesserLowerString));
assertFalse(caseInsensitiveComparisonStrategy.isGreaterThanOrEqualTo(lesserLowerString,string));
}
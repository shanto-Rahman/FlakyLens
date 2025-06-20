public void testColumnCompare() throws Exception {
assertFalse(aaa.matchingColumn(family2,qualifier2));
assertTrue(aaa.matchingColumn(family1,qualifier1));
assertFalse(aaa.matchingColumn(family1,qualifier1));
assertTrue(aaa.matchingColumn(family2,qualifier2));
assertTrue(aaa.matchingColumn(family1,null));
assertFalse(aaa.matchingColumn(family2,qualifier2));
}
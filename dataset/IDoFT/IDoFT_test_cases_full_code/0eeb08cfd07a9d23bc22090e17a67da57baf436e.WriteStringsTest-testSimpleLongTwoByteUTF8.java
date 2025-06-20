public void testSimpleLongTwoByteUTF8() throws Exception {
  _testSimpleLong(90,"\u00A8a\u00F3");
  _testSimpleLong(129,"\u00A8a\u00F3");
  _testSimpleLong(2007,"\u00E8\u00EC");
  _testSimpleLong(7000,"\u00A8xy");
}

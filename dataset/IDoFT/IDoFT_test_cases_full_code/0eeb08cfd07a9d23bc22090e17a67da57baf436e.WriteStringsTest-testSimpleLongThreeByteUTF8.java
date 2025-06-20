public void testSimpleLongThreeByteUTF8() throws Exception {
  _testSimpleLong(90,"\u2009\u3333");
  _testSimpleLong(129,"\u2009\u3333");
  _testSimpleLong(2007,"abc\u3333");
  _testSimpleLong(5000,"\u2009b\u3333a");
}

@Test public void testCustomQuote(){
  JSONCoderOption codeOption=JSONCoderOption.ofIndentFactor(2);
  codeOption.getJsonOption().setQuoteChar('\'');
  String str=toJSONString(buildTestBean(),codeOption);
  assertMatchesSnapshot("strWithSingleQuote",str);
  assertTrue("Single quote instead of double quote should be quoted when Quote char is set to single quote",str.indexOf("'String1: \\'\"'") > 0);
  assertEquals(toJSONString(JSONCoder.global.decode(str,TestBean.class),codeOption),str);
  codeOption.getJsonOption().setAlwaysQuoteName(false);
  str=toJSONString(buildTestBean(),codeOption);
  assertMatchesSnapshot("strWithNoKeyQuote",str);
  assertTrue("Key shouldn't be quoted when alwaysQuoteName is set to false",str.contains("treeMap:"));
  assertEquals(toJSONString(JSONCoder.global.decode(str,TestBean.class),codeOption),str);
  codeOption.getJsonOption().setQuoteChar('`');
  str=toJSONString(buildTestBean(),codeOption);
  assertMatchesSnapshot("strWithBackQuote",str);
  assertTrue("back quote should be quoted when quoteChar set to back quote",str.indexOf("`String1: '\"`") > 0);
}

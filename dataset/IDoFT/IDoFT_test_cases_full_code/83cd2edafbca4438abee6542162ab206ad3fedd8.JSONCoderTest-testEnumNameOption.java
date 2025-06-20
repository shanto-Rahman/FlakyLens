@Test public void testEnumNameOption(){
  JSONCoderOption codeOption=JSONCoderOption.ofIndentFactor(2).setShowEnumName(true);
  String str=toJSONString(buildTestBean(),codeOption);
  assertMatchesSnapshot(str);
  assertTrue("Should contain both enum id and name when showEnumName is set",str.indexOf("12345-value1") > 0);
  assertEquals(str,toJSONString(JSONCoder.global.decode(str,TestBean.class),codeOption));
}

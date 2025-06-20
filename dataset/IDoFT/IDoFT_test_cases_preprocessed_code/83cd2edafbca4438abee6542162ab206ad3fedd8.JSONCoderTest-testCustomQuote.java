@Test public void testCustomQuote(){
assertTrue("Single quote instead of double quote should be quoted when Quote char is set to single quote",str.indexOf("'String1: \\'\"'") > 0);
assertEquals(toJSONString(JSONCoder.global.decode(str,TestBean.class),codeOption),str);
assertTrue("Key shouldn't be quoted when alwaysQuoteName is set to false",str.contains("treeMap:"));
assertEquals(toJSONString(JSONCoder.global.decode(str,TestBean.class),codeOption),str);
assertTrue("back quote should be quoted when quoteChar set to back quote",str.indexOf("`String1: '\"`") > 0);
}
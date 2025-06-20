@Test public void testCheckXPathsIncorrect(){
  XmlHttpResponse resp=getOKResponse();
  Map<String,Object> values=new HashMap<String,Object>();
  values.put("amount","12");
  values.put("result","1");
  values.put("status","OK");
  Map<String,String> expressionsToCheck=createExprToCheck();
  expressionsToCheck.put("//*[local-name()='errorStatus']","unknownKey");
  expressionsToCheck.put("//noMatchXPath","status");
  String expected=SoapCallMapColumnFixture.NO_ESCAPE_PREFIX + "NOK:\n<ul>\n" + " <li>amount: 12 <> 158.86</li>\n"+ " <li>unknownKey: null <> OK</li>\n"+ " <li>status: OK <> null</li>\n"+ " <li>result: 1 <> 13.44</li>\n"+ "</ul>";
  XPathCheckResult checkResult=resp.checkXPaths(values,expressionsToCheck);
  assertEquals("NOK",checkResult.getResult());
  assertEquals(expected,checkResult.getMismatchDetail());
}

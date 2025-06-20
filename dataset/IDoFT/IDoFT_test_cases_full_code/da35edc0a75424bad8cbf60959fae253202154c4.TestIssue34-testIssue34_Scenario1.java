@Test public void testIssue34_Scenario1() throws ScriptCPUAbuseException, ScriptException {
  String js="";
  js+="function main(){\n";
  js+="	for(var i=0;i<2;i++)\n";
  js+="	logger.debug('loop cnt-'+i);\n";
  js+="}\n";
  js+="function main2(){\n";
  js+="}\n";
  js+="main();\n";
  sandbox.eval(js);
  Assert.assertTrue(logger.getOutput().contains("loop cnt-0"));
}

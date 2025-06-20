@Test public void testParse(){
  CLISpec spec=new CLISpec(Arg1.class);
  assertMatchesSnapshot("spec",spec);
  log.info("spec:\n" + spec.printUsage());
  assertMatchesSnapshot("usage",spec.printUsage());
  String[] args={"abc","10","name:n1,x:1,y:2","-o","VAL2","--optInt","100","--arrayArg","str1,str2,'It\\'s escapted'","--arrayArg","array as separate option"};
  CLIParser parser=spec.parse(args,0);
  log.info("parsedValue:\n" + parser.target);
  assertMatchesSnapshot("parserTarget",parser.target);
  String[] argsWithError={"-o","VAL2","--optInt1"};
  parser=spec.parse(argsWithError,0);
  assertTrue(parser.hasError());
  assertMatchesSnapshot("parseError",parser.getErrorsAsString());
}

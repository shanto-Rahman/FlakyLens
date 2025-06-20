@Test public void testKarateToJson(){
  ScenarioContext ctx=getContext();
  Script.assign("SP","Java.type('com.intuit.karate.SimplePojo')",ctx);
  Script.assign("sp","new SP()",ctx);
  Script.evalJsExpression("sp.bar = 10",ctx);
  Script.assign("foo","karate.toJson(sp)",ctx);
  Script.assign("bar","karate.toJson(sp, true)",ctx);
  assertTrue(Script.matchNamed(MatchType.EQUALS,"foo",null,"{ foo: null, bar: 10 }",ctx).pass);
  assertTrue(Script.matchNamed(MatchType.EQUALS,"bar",null,"{ bar: 10 }",ctx).pass);
}

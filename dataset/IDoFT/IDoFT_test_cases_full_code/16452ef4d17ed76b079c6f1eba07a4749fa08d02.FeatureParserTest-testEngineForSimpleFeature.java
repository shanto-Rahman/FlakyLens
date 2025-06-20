@Test void testEngineForSimpleFeature(){
  FeatureResult result=execute("test-simple.feature");
  Map<String,Object> map=result.toCucumberJson();
  match(map.get("tags"),"[{ name: '@foo', line: 1 }]");
  ScenarioResult sr=result.getScenarioResults().get(0);
  map=sr.toCucumberJson();
  match(map.get("tags"),"[{ name: '@bar', line: 5 }, { name: '@foo', line: 1 }]");
  ReportUtils.saveCucumberJson("target",result,null);
  ReportUtils.saveJunitXml("target",result,null);
}

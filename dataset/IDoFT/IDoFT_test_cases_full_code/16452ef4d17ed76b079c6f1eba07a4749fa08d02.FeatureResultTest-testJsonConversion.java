@Test void testJsonConversion(){
  run("feature-result.feature");
  Map<String,Object> featureResult=fr.result.toKarateJson();
  String expected=FileUtils.toString(new File("src/test/java/com/intuit/karate/core/feature-result.json"));
  match(featureResult,expected);
  FeatureResult temp=FeatureResult.fromKarateJson(fr.suite.workingDir,featureResult);
  Report report=SuiteReports.DEFAULT.featureReport(fr.suite,fr.result);
  File file=report.render("target");
  logger.debug("saved report: {}",file.getAbsolutePath());
  Map<String,Object> karateClone=temp.toKarateJson();
  match(featureResult,karateClone);
  Map<String,Object> cucumberClone=temp.toCucumberJson();
  expected=FileUtils.toString(new File("src/test/java/com/intuit/karate/core/feature-result-cucumber.json"));
  match(cucumberClone,expected);
}

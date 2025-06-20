@Test void testJsonConversion(){
String expected=FileUtils.toString(new File("src/test/java/com/intuit/karate/core/feature-result.json"));//RO
expected=FileUtils.toString(new File("src/test/java/com/intuit/karate/core/feature-result-cucumber.json"));//RO
}
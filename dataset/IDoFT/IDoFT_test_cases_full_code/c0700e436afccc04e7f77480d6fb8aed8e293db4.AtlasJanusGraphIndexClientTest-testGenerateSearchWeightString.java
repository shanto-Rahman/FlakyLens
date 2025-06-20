@Test public void testGenerateSearchWeightString(){
  Map<String,Integer> fields=new HashMap<>();
  fields.put("one",10);
  fields.put("two",1);
  fields.put("three",15);
  String generatedString=AtlasJanusGraphIndexClient.generateSearchWeightString(fields);
  Assert.assertEquals(generatedString," one^10 two^1 three^15");
}

@Test public void twin() throws Exception {
  final ObjectMapper mapper=mapperWithModule();
  Object sampleOne=randomSample(Object.class);
  Object sampleTwo=randomSample(Object.class);
  String expectedJson1="{\"one\":" + mapper.writeValueAsString(sampleOne) + ",\"two\":"+ mapper.writeValueAsString(sampleTwo)+ "}";
  String expectedJson2="{\"two\":" + mapper.writeValueAsString(sampleTwo) + ",\"one\":"+ mapper.writeValueAsString(sampleOne)+ "}";
  Twin<String> twin=Tuples.twin((String)sampleOne,(String)sampleTwo);
  String writeValue=mapper.writeValueAsString(twin);
  boolean assert1=writeValue.equals(expectedJson1);
  boolean assert2=writeValue.equals(expectedJson2);
  Assert.assertTrue(assert1 || assert2);
  Assert.assertEquals(twin,mapper.readValue(expectedJson1,new TypeReference<Twin<String>>(){
  }
));
}

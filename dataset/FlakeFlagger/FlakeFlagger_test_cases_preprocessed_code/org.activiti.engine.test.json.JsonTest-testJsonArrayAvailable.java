@Deployment public void testJsonArrayAvailable(){
assertNotNull(value);
assertEquals("myValue",value.get(0).get("var").asText());
assertNotNull(value);
assertEquals("myValue",value.get(0).get("var").asText());
assertEquals("myOtherValue",value.get(1).get("var").asText());
assertNotNull(task);
assertNotNull(value);
assertEquals("myValue",value.get(0).get("var").asText());
assertEquals("myOtherValue",value.get(1).get("var").asText());
assertEquals("myThirdValue",value.get(2).get("var").asText());
assertNotNull(task);
assertEquals("userTaskSuccess",task.getTaskDefinitionKey());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertNotNull(value);
assertEquals("myValue",value.get(0).get("var").asText());
assertEquals("myOtherValue",value.get(1).get("var").asText());
assertEquals("myThirdValue",value.get(2).get("var").asText());
}
}
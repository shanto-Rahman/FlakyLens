@Deployment public void testDirectJsonPropertyAccess(){
assertNotNull(value);
assertEquals("myValue",value.get("var").asText());
assertNotNull(task);
assertNotNull(value);
assertEquals("myValue",value.get("var").asText());
assertEquals("myOtherValue",value.get("var2").asText());
assertEquals("myThirdValue",value.get("var3").asText());
assertNotNull(task);
assertEquals("userTaskSuccess",task.getTaskDefinitionKey());
}
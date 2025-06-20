public void testProcessDefinitionProperties(){
assertEquals("one",processDefinition.getKey());
assertEquals("One",processDefinition.getName());
assertTrue(processDefinition.getId().startsWith("one:1"));
assertEquals("Examples",processDefinition.getCategory());
assertEquals("one",processDefinition.getKey());
assertEquals("One",processDefinition.getName());
assertTrue(processDefinition.getId().startsWith("one:2"));
assertEquals("Examples",processDefinition.getCategory());
assertEquals("two",processDefinition.getKey());
assertEquals("Two",processDefinition.getName());
assertTrue(processDefinition.getId().startsWith("two:1"));
assertEquals("Examples2",processDefinition.getCategory());
}
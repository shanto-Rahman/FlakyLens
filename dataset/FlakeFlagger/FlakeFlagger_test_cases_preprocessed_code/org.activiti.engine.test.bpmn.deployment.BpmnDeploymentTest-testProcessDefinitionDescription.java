@Deployment public void testProcessDefinitionDescription(){
assertEquals("This is really good process documentation!",processDefinition.getDescription());
}
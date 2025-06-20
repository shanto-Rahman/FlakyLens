@Deployment public void testGetBpmnXmlFileThroughService(){
assertEquals(1,deploymentResources.size());
assertEquals(bpmnResourceName,deploymentResources.get(0));
assertEquals(bpmnResourceName,processDefinition.getResourceName());
assertNull(processDefinition.getDiagramResourceName());
assertFalse(processDefinition.hasStartFormKey());
assertNull(readOnlyProcessDefinition.getDiagramResourceName());
assertTrue(contentFromDeployment.length() > 0);
assertTrue(contentFromDeployment.contains("process id=\"emptyProcess\""));
assertEquals(contentFromFile,contentFromDeployment);
}
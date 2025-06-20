@Deployment(resources={"org/activiti/engine/test/bpmn/deployment/BpmnDeploymentTest.testProcessDiagramResource.bpmn20.xml","org/activiti/engine/test/bpmn/deployment/BpmnDeploymentTest.testProcessDiagramResource.jpg"}) public void testProcessDiagramResource(){
assertEquals("org/activiti/engine/test/bpmn/deployment/BpmnDeploymentTest.testProcessDiagramResource.bpmn20.xml",processDefinition.getResourceName());
assertEquals(1,startEvents.size());
assertEquals("someFormKey",startEvents.get(0).getFormKey());
assertEquals("org/activiti/engine/test/bpmn/deployment/BpmnDeploymentTest.testProcessDiagramResource.jpg",diagramResourceName);
assertEquals(33343,diagramBytes.length);
}
@Deployment(resources={"org/activiti/standalone/jpa/HistoricJPAVariableTest.testGetJPAEntityAsHistoricLog.bpmn20.xml"}) public void testGetJPAUpdateEntityAsHistoricLog(){
variables.put("simpleEntityFieldAccess",simpleEntityFieldAccess);//RW
taskService.setVariable(task.getId(),"simpleEntityFieldAccess",simpleEntityFieldAccess);//RW
assertTrue(value instanceof FieldAccessJPAEntity);
assertEquals(((FieldAccessJPAEntity)value).getValue(),simpleEntityFieldAccess.getValue());//RW
}
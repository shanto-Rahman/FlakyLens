@Deployment(resources={"org/activiti/engine/test/bpmn/event/error/mapError/BoundaryErrorMapTest.testCallProcessSingleDirectMap.bpmn20.xml","org/activiti/engine/test/bpmn/event/error/mapError/BoundaryErrorMapTest.testCallProcessCalee.bpmn20.xml"}) public void testCallProcessSingleDirectMap(){
assertTrue(FlagDelegate.isVisited());
}
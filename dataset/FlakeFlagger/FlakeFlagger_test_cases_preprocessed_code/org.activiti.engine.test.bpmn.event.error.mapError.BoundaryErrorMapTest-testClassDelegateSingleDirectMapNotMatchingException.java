@Deployment(resources="org/activiti/engine/test/bpmn/event/error/mapError/BoundaryErrorMapTest.testClassDelegateSingleDirectMap.bpmn20.xml") public void testClassDelegateSingleDirectMapNotMatchingException(){
assertEquals(0,ServiceTaskTestMock.CALL_COUNT.get());
fail("exception expected, as there is no matching exception map");
assertFalse(FlagDelegate.isVisited());
}
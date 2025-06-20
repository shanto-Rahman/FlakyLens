public void testQueryByProcessInstanceId(){
assertEquals(3,query.list().size());
assertEquals(3,query.count());
assertEquals(2,runtimeService.createExecutionQuery().processInstanceId(sequentialProcessInstanceIds.get(0)).list().size());
}
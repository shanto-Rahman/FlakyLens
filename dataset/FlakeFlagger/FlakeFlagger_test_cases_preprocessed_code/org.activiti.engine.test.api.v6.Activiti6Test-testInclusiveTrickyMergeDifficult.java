/** 
 * Based on the process and use cases described in http://www.bp-3.com/blogs/2013/09/joins-and-ibm-bpm-diving-deeper/
 */
@Test @org.activiti.engine.test.Deployment(resources="org/activiti/engine/test/api/v6/Activiti6Test.testInclusiveTrickyMerge.bpmn20.xml") public void testInclusiveTrickyMergeDifficult(){
assertEquals(3,taskService.createTaskQuery().count());
assertEquals(3,tasks.size());
assertEquals("A",tasks.get(0).getName());
assertEquals("B",tasks.get(1).getName());
assertEquals("C",tasks.get(2).getName());
assertEquals(1,tasks.size());
assertEquals("C",tasks.get(0).getName());
assertEquals(2,tasks.size());
assertEquals("D",tasks.get(0).getName());
assertEquals("E",tasks.get(1).getName());
assertEquals(0,runtimeService.createExecutionQuery().count());
}
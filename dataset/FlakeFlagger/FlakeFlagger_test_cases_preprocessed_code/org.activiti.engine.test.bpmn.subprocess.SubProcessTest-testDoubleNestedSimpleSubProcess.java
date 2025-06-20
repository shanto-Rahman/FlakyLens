/** 
 * Test case where the simple sub process of previous test cases is nested within two other sub processes
 */
@Deployment public void testDoubleNestedSimpleSubProcess(){
assertEquals("Task in subprocess",subProcessTask.getName());
assertEquals("Task after subprocesses",taskAfterSubProcesses.getName());
}
/** 
 * Test case where the simple sub process of previous test cases is nested within another subprocess.
 */
@Deployment public void testNestedSimpleSubProcess(){
assertEquals("Task in subprocess",subProcessTask.getName());
assertNotNull(taskAfterSubProcesses);
assertEquals("Task after subprocesses",taskAfterSubProcesses.getName());
}
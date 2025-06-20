/** 
 * A testcase to produce and fix issue ACT-862.
 */
@Deployment public void testVariableNamesScope(){
assertEquals("Task in subprocess",subProcessTask.getName());
assertTrue(result.contains("test"));
assertTrue(result.contains("helloWorld"));
assertTrue(result.contains("mainProcessLocalVariable"));
assertFalse(result.contains("subProcessLocalVariable"));
assertTrue(result.contains("test"));
assertTrue(result.contains("mainProcessLocalVariable"));
assertTrue(result.contains("helloWorld"));
assertFalse(result.contains("subProcessLocalVariable"));
assertTrue(result.contains("test"));
assertTrue(result.contains("subProcessLocalVariable"));
assertFalse(result.contains("helloWorld"));
assertFalse(result.contains("mainProcessLocalVariable"));
assertTrue(result.contains("test"));
assertTrue(result.contains("subProcessLocalVariable"));
assertTrue(result.contains("helloWorld"));
assertTrue(result.contains("mainProcessLocalVariable"));
}
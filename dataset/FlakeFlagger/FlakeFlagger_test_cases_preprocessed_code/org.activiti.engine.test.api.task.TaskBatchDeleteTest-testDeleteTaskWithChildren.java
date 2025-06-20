/** 
 * Validating fix for ACT-2070
 */
@Deployment public void testDeleteTaskWithChildren() throws Exception {
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertNotNull(firstTask);
assertNull(processInstance);
}
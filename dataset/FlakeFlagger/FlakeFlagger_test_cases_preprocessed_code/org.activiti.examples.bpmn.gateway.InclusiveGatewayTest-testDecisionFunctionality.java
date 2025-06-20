/** 
 * The test process has an OR gateway where, the 'input' variable is used to select the expected outgoing sequence flow.
 */
@Deployment public void testDecisionFunctionality(){
assertEquals(3,tasks.size());
assertEquals(0,expectedMessages.size());
assertEquals(2,tasks.size());
assertEquals(0,expectedMessages.size());
assertEquals(1,tasks.size());
assertEquals(0,expectedMessages.size());
fail();
}
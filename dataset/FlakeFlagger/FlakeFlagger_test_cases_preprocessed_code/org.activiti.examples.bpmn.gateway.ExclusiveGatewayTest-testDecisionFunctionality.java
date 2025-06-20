/** 
 * The test process has an XOR gateway where, the 'input' variable is used to select one of the outgoing sequence flow. Every one of those sequence flow goes to another task, allowing us to test the decision very easily.
 */
@Deployment public void testDecisionFunctionality(){
assertEquals("Send e-mail for more information",task.getName());
assertEquals("Check account balance",task.getName());
assertEquals("Call customer",task.getName());
fail();
}
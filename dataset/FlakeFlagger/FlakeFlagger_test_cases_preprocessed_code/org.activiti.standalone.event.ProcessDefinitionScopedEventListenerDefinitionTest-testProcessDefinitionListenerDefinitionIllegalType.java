/** 
 * Test to verify if event listeners defined in the BPMN XML which have illegal event-types cause an exception on deploy.
 */
public void testProcessDefinitionListenerDefinitionIllegalType() throws Exception {
fail("Exception expected");
assertTrue(ae instanceof ActivitiIllegalArgumentException);
assertEquals("Invalid event-type: invalid",ae.getMessage());
if (deployment != null) {
}
}
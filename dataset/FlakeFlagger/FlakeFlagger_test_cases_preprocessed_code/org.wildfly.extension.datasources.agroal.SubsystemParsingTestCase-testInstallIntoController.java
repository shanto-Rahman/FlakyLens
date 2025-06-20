/** 
 * Test that the model created from the xml looks as expected
 */
@Test public void testInstallIntoController() throws Exception {
Assert.assertTrue(model.get(SUBSYSTEM).hasDefined(AgroalExtension.SUBSYSTEM_NAME));
}
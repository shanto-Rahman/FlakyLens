/** 
 * Tests that the xml is parsed into the correct operations
 */
@Test public void testParseSubsystem() throws Exception {
Assert.assertEquals(1,operations.size());
Assert.assertEquals(ADD,addSubsystem.get(OP).asString());
Assert.assertEquals(1,address.size());
Assert.assertEquals(SUBSYSTEM,element.getKey());
Assert.assertEquals(AgroalExtension.SUBSYSTEM_NAME,element.getValue());
}
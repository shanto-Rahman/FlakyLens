@Test public void testExtractNoGroupName(){
Assert.assertEquals("test",groupName);
Assert.assertEquals("test.group",groupName);
Assert.assertEquals(null,victim.getGroupName(mockRequestForUri("/123/")));
}
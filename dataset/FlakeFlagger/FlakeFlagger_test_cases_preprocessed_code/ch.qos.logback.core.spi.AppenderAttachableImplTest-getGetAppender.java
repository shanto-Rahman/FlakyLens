@Test public void getGetAppender() throws Exception {
assertNotNull("Could not find appender",a);
assertTrue("Wrong appender",a == testOther);
assertNotNull("Could not find appender",a);
assertTrue("Wrong appender",a == test);
assertNull("Appender was returned",a);
}
@Test public void testSessionManagementOperationsNegative() throws Exception {
if (cookie.getValue().startsWith("JSESSIONID=")) {
}
Assert.assertEquals("undefined",opRes.get(ModelDescriptionConstants.RESULT).asString());
}
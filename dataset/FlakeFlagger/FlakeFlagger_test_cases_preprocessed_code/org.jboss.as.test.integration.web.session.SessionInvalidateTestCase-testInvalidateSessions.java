@Test public void testInvalidateSessions() throws Exception {
Assert.assertEquals("success",opRes.get(ModelDescriptionConstants.OUTCOME).asString());
Assert.assertEquals(false,opRes.get(ModelDescriptionConstants.RESULT).asBoolean());
if (cookie.getValue().startsWith("JSESSIONID=")) {
}
Assert.assertNotNull(sessionId);
assertEquals("0",result);
assertEquals("1",result);
assertEquals("2",result);
Assert.assertEquals("success",opRes.get(ModelDescriptionConstants.OUTCOME).asString());
Assert.assertEquals(true,opRes.get(ModelDescriptionConstants.RESULT).asBoolean());
assertEquals("0",result);
assertEquals("1",result);
}
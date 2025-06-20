@Test public void testSessionManagementOperations() throws Exception {
Assert.assertEquals(opRes.toString(),"success",opRes.get(ModelDescriptionConstants.OUTCOME).asString());
Assert.assertEquals(Collections.emptyList(),opRes.get(ModelDescriptionConstants.RESULT).asList());
if (cookie.getValue().startsWith("JSESSIONID=")) {
}
Assert.assertNotNull(sessionId);
Assert.assertEquals(opRes.toString(),"success",opRes.get(ModelDescriptionConstants.OUTCOME).asString());
Assert.assertEquals(opRes.toString(),Collections.singletonList(new ModelNode(sessionId)),opRes.get(ModelDescriptionConstants.RESULT).asList());
Assert.assertTrue(c1 <= time1);
Assert.assertTrue(time1 <= c2);
Assert.assertEquals(time1,sessionCreationTime);
Assert.assertEquals(time1,opRes.get(ModelDescriptionConstants.RESULT).asLong());
Assert.assertEquals(time1,aTime2);
Assert.assertEquals(sessionCreationTime,aTime2);
Assert.assertEquals(1,resultList.size());
Assert.assertEquals(opRes.toString(),"val",resultList.get(0).asString());
Assert.assertEquals(opRes.toString(),1,properties.size());
Assert.assertEquals(opRes.toString(),"val",property.getName());
Assert.assertEquals(opRes.toString(),"0",property.getValue().asString());
Thread.sleep(10);
if (time1 != sessionCreationTime) {
}
Assert.assertTrue(a1 <= time1);
Assert.assertTrue(time1 <= a2);
Assert.assertEquals(time1,time2);
Assert.assertEquals("1",opRes.get(ModelDescriptionConstants.RESULT).asString());
Assert.assertEquals(Collections.emptyList(),opRes.get(ModelDescriptionConstants.RESULT).asList());
}
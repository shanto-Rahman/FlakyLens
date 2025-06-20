@Test public void testMapExceptionWithNoExceptionClass() throws Exception {
assertNotNull(flowElement);
assertTrue(flowElement instanceof ServiceTask);
assertEquals("servicetaskWithAndTrueAndChildren",flowElement.getId());
assertNotNull(serviceTask.getMapExceptions());
assertEquals(1,serviceTask.getMapExceptions().size());
assertNotNull(serviceTask.getMapExceptions().get(0).getClassName());
assertEquals(0,serviceTask.getMapExceptions().get(0).getClassName().length());
}
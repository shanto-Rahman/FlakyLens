@Test public void testWarningError() throws UnsupportedEncodingException, XMLStreamException {
Assert.assertNotNull(bpmnModel);
Assert.assertEquals(1,allErrors.size());
Assert.assertTrue(allErrors.get(0).isWarning());
}
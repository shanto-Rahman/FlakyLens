@Test public void testJaxbToString() throws Exception {
LOG.info("Command is " + StageUtils.jaxbToString(wrapper.getExecutionCommand()));//RW
assertEquals(StageUtils.getActionId(1,2),s.getActionId());
}
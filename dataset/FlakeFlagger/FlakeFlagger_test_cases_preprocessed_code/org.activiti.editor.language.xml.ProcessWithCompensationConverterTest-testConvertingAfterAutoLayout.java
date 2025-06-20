@Test public void testConvertingAfterAutoLayout(){
if (bpmnModel1.getLocationMap().size() == 0) {
}
assertEquals(10,bpmnModel1.getLocationMap().size());
assertEquals(10,bpmnModel2.getLocationMap().size());
assertEquals(7,bpmnModel1.getFlowLocationMap().size());
assertEquals(7,bpmnModel2.getFlowLocationMap().size());
}
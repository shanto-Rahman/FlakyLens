@Deployment(resources={"org/activiti/engine/test/bpmn/StartToEndTest.testStartWithSerializableVariables.bpmn20.xml"}) public void testStartProcessInstanceWithSerializbleVariables(){
assertEquals("hello",returnVarMap.get("test"));
assertEquals("1",person1.getId());//IT
assertEquals("John",person1.getName());//IT
assertEquals("2",person2.getId());//IT
assertEquals("Paul",person2.getName());//IT
}
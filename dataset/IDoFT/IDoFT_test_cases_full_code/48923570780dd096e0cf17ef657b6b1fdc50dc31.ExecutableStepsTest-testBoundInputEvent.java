@Test public void testBoundInputEvent(){
  List<Input> inputs=Arrays.asList(new Input.InputBuilder("input1",5).build(),new Input.InputBuilder("input2",3,true).withRequired(true).withPrivateInput(false).build());
  final RunEnvironment runEnv=new RunEnvironment();
  final ExecutionRuntimeServices runtimeServices=new ExecutionRuntimeServices();
  Map<String,Value> resultMap=new HashMap<>();
  resultMap.put("input1",ValueFactory.create(inputs.get(0).getValue()));
  resultMap.put("input2",ValueFactory.create(inputs.get(1).getValue()));
  when(inputsBinding.bindInputs(eq(inputs),anyMap(),anyMap(),anySet(),anyList(),anyBoolean(),anyMap())).thenReturn(resultMap);
  executableSteps.startExecutable(inputs,runEnv,new HashMap<String,Value>(),runtimeServices,"dockerizeStep",2L,ExecutableType.FLOW,new SystemContext(),false);
  Collection<ScoreEvent> events=runtimeServices.getEvents();
  assertFalse(events.isEmpty());
  ScoreEvent boundInputEvent=null;
  for (  ScoreEvent event : events) {
    if (event.getEventType().equals(ScoreLangConstants.EVENT_INPUT_END)) {
      boundInputEvent=event;
    }
  }
  assertNotNull(boundInputEvent);
  LanguageEventData eventData=(LanguageEventData)boundInputEvent.getData();
  assertTrue(eventData.containsKey(LanguageEventData.BOUND_INPUTS));
  assertNotNull(eventData.getStepName());
  assertEquals(LanguageEventData.StepType.FLOW,eventData.getStepType());
  assertEquals("dockerizeStep",eventData.getStepName());
  @SuppressWarnings("unchecked") Map<String,Serializable> inputsBounded=(Map<String,Serializable>)eventData.get(LanguageEventData.BOUND_INPUTS);
  Set<Map.Entry<String,Serializable>> inputEntries=inputsBounded.entrySet();
  Iterator<Map.Entry<String,Serializable>> inputNamesIterator=inputEntries.iterator();
  Map.Entry<String,Serializable> firstInput=inputNamesIterator.next();
  assertEquals("Inputs are not in defined order in end inputs binding event","input1",firstInput.getKey());
  assertEquals(5,firstInput.getValue());
  Map.Entry<String,Serializable> secondInput=inputNamesIterator.next();
  assertEquals("Inputs are not in defined order in end inputs binding event","input2",secondInput.getKey());
  assertEquals(SensitiveValue.SENSITIVE_VALUE_MASK,secondInput.getValue());
}

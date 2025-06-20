/** 
 * Test  {@link DatastoreConverters.CheckNoKey} with only invalid entities. 
 */
@Test @Category(NeedsRunner.class) public void testCheckNoKeyAllInvalid() throws Exception {
  List<Entity> testEntitiesWithNoKey=new ArrayList<>();
  List<String> expectedErrors=new ArrayList<>();
  EntityJsonPrinter entityJsonPrinter=new EntityJsonPrinter();
  for (int i=0; i < entities.size(); i++) {
    Entity noKeyEntity=Entity.newBuilder().putProperties("street",Value.newBuilder().setStringValue("Some street").build()).putProperties("number",Value.newBuilder().setIntegerValue(1L).build()).build();
    testEntitiesWithNoKey.add(noKeyEntity);
    expectedErrors.add(ErrorMessage.newBuilder().setMessage("Datastore Entity Without Key").setData(entityJsonPrinter.print(noKeyEntity)).build().toJson());
  }
  TupleTag<Entity> successTag=new TupleTag<Entity>("entities"){
  }
;
  TupleTag<String> failureTag=new TupleTag<String>("failures"){
  }
;
  PCollectionTuple results=pipeline.apply("Create",Create.of(testEntitiesWithNoKey)).apply("RemoveNoKeys",CheckNoKey.newBuilder().setSuccessTag(successTag).setFailureTag(failureTag).build());
  PAssert.that(results.get(successTag)).empty();
  PAssert.that(results.get(failureTag)).containsInAnyOrder(expectedErrors);
  pipeline.run();
}

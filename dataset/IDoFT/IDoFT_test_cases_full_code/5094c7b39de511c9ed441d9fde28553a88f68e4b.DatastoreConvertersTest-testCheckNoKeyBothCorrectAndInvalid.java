/** 
 * Test  {@link DatastoreConverters.CheckNoKey} with both correct and invalid entities. 
 */
@Test @Category(NeedsRunner.class) public void testCheckNoKeyBothCorrectAndInvalid() throws Exception {
  List<Entity> testEntitiesWithNoKey=new ArrayList<>();
  List<String> expectedErrors=new ArrayList<>();
  EntityJsonPrinter entityJsonPrinter=new EntityJsonPrinter();
  for (int i=0; i < entities.size(); i++) {
    Entity noKeyEntity=Entity.newBuilder().putProperties("street",Value.newBuilder().setStringValue("Some street").build()).putProperties("number",Value.newBuilder().setIntegerValue(i).build()).build();
    testEntitiesWithNoKey.add(noKeyEntity);
    expectedErrors.add(ErrorMessage.newBuilder().setMessage("Datastore Entity Without Key").setData(entityJsonPrinter.print(noKeyEntity)).build().toJson());
  }
  List<Entity> testEntities=new ArrayList<>(entities);
  testEntities.addAll(testEntitiesWithNoKey);
  TupleTag<Entity> successTag=new TupleTag<Entity>("entities"){
  }
;
  TupleTag<String> failureTag=new TupleTag<String>("failures"){
  }
;
  PCollectionTuple results=pipeline.apply("Create",Create.of(testEntities)).apply("RemoveNoKeys",CheckNoKey.newBuilder().setSuccessTag(successTag).setFailureTag(failureTag).build());
  PAssert.that(results.get(successTag)).containsInAnyOrder(entities);
  PAssert.that(results.get(failureTag)).containsInAnyOrder(expectedErrors);
  pipeline.run();
}

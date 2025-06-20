/** 
 * Unit test for  {@link DatastoreConverters.CheckSameKey}. 
 */
@Test @Category(NeedsRunner.class) public void testCheckSameKey() throws Exception {
  Entity dupKeyEntity=Entity.newBuilder().setKey(entities.get(0).getKey()).putProperties("SomeBSProp",Value.newBuilder().setStringValue("Some BS Value").build()).build();
  ArrayList<Entity> testEntitiesWithConflictKey=new ArrayList<>(entities);
  testEntitiesWithConflictKey.add(dupKeyEntity);
  List<String> expectedErrors=new ArrayList<>();
  EntityJsonPrinter entityJsonPrinter=new EntityJsonPrinter();
  for (  Entity e : Arrays.asList(entities.get(0),dupKeyEntity)) {
    expectedErrors.add(ErrorMessage.newBuilder().setMessage("Duplicate Datastore Key").setData(entityJsonPrinter.print(e)).build().toJson());
  }
  TupleTag<Entity> goodTag=new TupleTag<Entity>("entities"){
  }
;
  TupleTag<String> errorTag=new TupleTag<String>("errors"){
  }
;
  PCollectionTuple results=pipeline.apply("Create",Create.of(testEntitiesWithConflictKey)).apply("RemoveDupKeys",CheckSameKey.newBuilder().setGoodTag(goodTag).setErrorTag(errorTag).build());
  PAssert.that(results.get(goodTag)).containsInAnyOrder(entities.subList(1,entities.size()));
  PAssert.that(results.get(errorTag)).containsInAnyOrder(expectedErrors);
  pipeline.run();
}

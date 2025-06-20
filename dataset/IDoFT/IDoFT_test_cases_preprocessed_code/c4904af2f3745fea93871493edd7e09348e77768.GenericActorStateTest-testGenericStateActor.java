/** 
 * Ensures that is possible save and restore the state with parametrized states.
 */
@Test public void testGenericStateActor() throws ExecutionException, InterruptedException {
assertEquals(0,fakeDatabase.values().size());
assertEquals(1,p2.x);
assertEquals(2,p2.y);
assertEquals("{\"data\":{\"x\":1,\"y\":2}}",fakeDatabase.values().stream().findFirst().get().toString());
}
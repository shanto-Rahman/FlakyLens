@Test public void testDone(){
Assert.fail("Expected IllegalStateException.");
Assert.assertSame(predicate,pb.toPredicate());
}
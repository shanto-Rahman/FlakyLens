@Test public void testVisitor(){
Assert.assertSame(equalsPredicate,visitor.visitedComparisonPredicate);
Assert.assertNull(visitor.visitedArrayPredicate);
Assert.assertNull(visitor.visitedUnaryPredicate);
Assert.assertNull(visitor.visitedComparisonPredicate);
Assert.assertSame(andPredicate,visitor.visitedArrayPredicate);
Assert.assertNull(visitor.visitedUnaryPredicate);
Assert.assertNull(visitor.visitedComparisonPredicate);
Assert.assertNull(visitor.visitedArrayPredicate);
Assert.assertSame(notPredicate,visitor.visitedUnaryPredicate);
}
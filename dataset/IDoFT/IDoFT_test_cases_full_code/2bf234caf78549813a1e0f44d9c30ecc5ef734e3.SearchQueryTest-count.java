@Test public void count(){
  BooleanExpression filter=user.emailAddress.eq("bob@example.com");
  assertEquals(1,query().where(filter).fetchCount());
}

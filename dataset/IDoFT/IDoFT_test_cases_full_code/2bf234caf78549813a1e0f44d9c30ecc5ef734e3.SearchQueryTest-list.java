@Test public void list(){
  BooleanExpression filter=user.emailAddress.eq("bob@example.com");
  List<User> list=query().where(filter).fetch();
  assertEquals(1,list.size());
  User u=query().where(filter).fetchOne();
  assertEquals(u,list.get(0));
}

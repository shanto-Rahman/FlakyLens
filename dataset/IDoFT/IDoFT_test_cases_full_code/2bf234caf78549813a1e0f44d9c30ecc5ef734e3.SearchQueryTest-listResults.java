@Test public void listResults(){
  BooleanExpression filter=user.middleName.eq("X");
  QueryResults<User> users=query().where(filter).orderBy(user.firstName.asc()).limit(2).fetchResults();
  List<String> asc=getFirstNames(users.getResults());
  assertEquals(Arrays.asList("Anton","Barbara"),asc);
  assertEquals(4,users.getTotal());
}

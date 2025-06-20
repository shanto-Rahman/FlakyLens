@Test public void ordering(){
  BooleanExpression filter=user.middleName.eq("X");
  List<String> asc=getFirstNames(query().where(filter).orderBy(user.firstName.asc()).fetch());
  assertEquals(Arrays.asList("Anton","Barbara","John","Robert"),asc);
  List<String> desc=getFirstNames(query().where(filter).orderBy(user.firstName.desc()).fetch());
  assertEquals(Arrays.asList("Robert","John","Barbara","Anton"),desc);
}

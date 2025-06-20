@Test public void paging(){
  BooleanExpression filter=user.middleName.eq("X");
  OrderSpecifier<?> order=user.firstName.asc();
  List<String> limit=getFirstNames(query().where(filter).orderBy(order).limit(2).fetch());
  assertEquals(Arrays.asList("Anton","Barbara"),limit);
  List<String> offset=getFirstNames(query().where(filter).orderBy(order).offset(1).fetch());
  assertEquals(Arrays.asList("Barbara","John","Robert"),offset);
  List<String> limitAndOffset=getFirstNames(query().where(filter).orderBy(order).limit(2).offset(1).fetch());
  assertEquals(Arrays.asList("Barbara","John"),limitAndOffset);
}

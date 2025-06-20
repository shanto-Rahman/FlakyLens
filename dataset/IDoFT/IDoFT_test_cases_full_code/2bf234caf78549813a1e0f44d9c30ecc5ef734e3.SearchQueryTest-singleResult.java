@Test public void singleResult(){
  assertNotNull(query().where(user.middleName.eq("X")).fetchFirst());
}

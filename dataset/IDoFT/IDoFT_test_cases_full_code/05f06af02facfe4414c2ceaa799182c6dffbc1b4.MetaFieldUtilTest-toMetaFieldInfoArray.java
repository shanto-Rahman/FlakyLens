@Test public void toMetaFieldInfoArray() throws Exception {
  Administrator emp=new Administrator();
  MetaFieldInfo[] fields=MetaFieldUtil.toMetaFieldInfoArray(emp);
  Assert.assertEquals(12,fields.length);
  Assert.assertEquals("First Name",fields[0].name);
  Assert.assertEquals("Last Name",fields[1].name);
  Assert.assertEquals("email",fields[2].name);
  Assert.assertEquals("ID",fields[3].name);
  Assert.assertEquals("Active?",fields[4].name);
  Assert.assertEquals("loginCounter",fields[5].name);
  Assert.assertEquals("The first name of this user",fields[0].description);
  Assert.assertEquals("",fields[1].description);
  Assert.assertEquals("",fields[2].description);
  emp.setFirstName("John");
  emp.setLastName("Doe");
  fields=MetaFieldUtil.toMetaFieldInfoArray(emp,"EMPTY");
  Assert.assertEquals("John",fields[0].value);
  Assert.assertEquals("Doe",fields[1].value);
  Assert.assertEquals("EMPTY",fields[2].value);
}

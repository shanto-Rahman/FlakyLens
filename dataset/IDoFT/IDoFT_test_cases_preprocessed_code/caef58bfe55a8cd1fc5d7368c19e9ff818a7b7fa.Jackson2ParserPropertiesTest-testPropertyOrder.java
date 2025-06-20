@Test public void testPropertyOrder(){
Assert.assertEquals(Arrays.asList("password1","id2","name","id1","password2"),getProperties(UserOrdered.class));
Assert.assertEquals(Arrays.asList("id1","id2","name","password1","password2"),getProperties(UserAlphabetic.class));
Assert.assertEquals(Arrays.asList("password2","password1","id2","id1","name"),getProperties(UserIndexed.class));
Assert.assertEquals(Arrays.asList("name","id1","id2","password1","password2"),getProperties(User1.class));
Assert.assertEquals(Arrays.asList("name","id1","id2","password1","password2"),getProperties(User2.class));
Assert.assertEquals(Arrays.asList("name","password1","password2","id1","id2"),getProperties(User3.class));
Assert.assertEquals(Arrays.asList("password1","id1","password2","id2","name"),getProperties(User4.class));
}
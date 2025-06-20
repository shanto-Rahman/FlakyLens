@Test public void assertRegisterTypeAdapter(){
assertThat(beforeRegisterGson.toJson(new GsonFactoryTest()),is("{}"));
assertThat(GsonFactory.getGson().toJson(new GsonFactoryTest()),is("test"));
}
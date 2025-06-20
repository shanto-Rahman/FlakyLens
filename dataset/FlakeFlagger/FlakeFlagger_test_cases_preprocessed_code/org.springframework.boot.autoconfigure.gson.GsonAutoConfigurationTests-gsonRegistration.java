@Test public void gsonRegistration(){
assertEquals("{\"data\":\"hello\"}",gson.toJson(new DataObject()));
}
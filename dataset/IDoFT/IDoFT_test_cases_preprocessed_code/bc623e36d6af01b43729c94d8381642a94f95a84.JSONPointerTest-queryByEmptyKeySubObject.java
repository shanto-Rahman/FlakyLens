@Test public void queryByEmptyKeySubObject(){
assertEquals("{\"\":\"empty key of an object with an empty key\",\"subKey\":\"Some" + " other value\"}",query("/obj/").toString());
}
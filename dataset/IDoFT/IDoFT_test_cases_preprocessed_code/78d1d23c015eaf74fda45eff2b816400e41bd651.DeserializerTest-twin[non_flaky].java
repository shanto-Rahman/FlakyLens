@Test public void twin() throws Exception {
Assert.assertTrue(assert1 || assert2);
Assert.assertEquals(twin,mapper.readValue(expectedJson1,new TypeReference<Twin<String>>(){
}
));
}
@Test public void twin() throws Exception {
Assert.assertEquals(expectedJson,mapper.writeValueAsString(twin));
Assert.assertEquals(twin,mapper.readValue(expectedJson,new TypeReference<Twin<String>>(){
}
));
}
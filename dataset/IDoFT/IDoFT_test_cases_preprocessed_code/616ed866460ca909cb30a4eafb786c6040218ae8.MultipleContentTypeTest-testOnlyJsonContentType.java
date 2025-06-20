@Test public void testOnlyJsonContentType(){
assertThat(response.getStatus()).isEqualTo(200);
assertThat(response.readEntity(String.class)).isEqualTo("{\"title\":\"Title#TEST\",\"content\":\"Content#TEST\"}");
}
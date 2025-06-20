@Test public void testPrettyPrintNoLineSeparator(){
assertThat(formatter.toJson(map)).isEqualTo(String.format("{%n" + "  \"hobbies\" : [ \"Reading\", \"Biking\", \"Snorkeling\" ],%n" + "  \"name\" : \"Jim\"%n"+ "}"));
}
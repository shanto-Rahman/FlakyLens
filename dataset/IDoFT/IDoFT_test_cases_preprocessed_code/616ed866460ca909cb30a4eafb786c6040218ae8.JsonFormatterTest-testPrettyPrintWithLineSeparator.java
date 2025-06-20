@Test public void testPrettyPrintWithLineSeparator(){
assertThat(formatter.toJson(map)).isEqualTo(String.format("{%n" + "  \"hobbies\" : [ \"Reading\", \"Biking\", \"Snorkeling\" ],%n" + "  \"name\" : \"Jim\"%n"+ "}%n"));
}
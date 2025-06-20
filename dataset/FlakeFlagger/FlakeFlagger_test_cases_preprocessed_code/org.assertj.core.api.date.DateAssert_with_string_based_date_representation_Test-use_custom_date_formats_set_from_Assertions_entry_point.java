@Test public void use_custom_date_formats_set_from_Assertions_entry_point(){
assertThat(date).isEqualTo("2003/04/26");
assertThat(e).hasMessage("Failed to parse 2003/04/26 with any of these date formats: " + "[yyyy/MM/dd'T'HH:mm:ss, yyyy-MM-dd'T'HH:mm:ss.SSS, yyyy-MM-dd HH:mm:ss.SSS, yyyy-MM-dd'T'HH:mm:ss, yyyy-MM-dd]");
assertThat(date).isEqualTo("2003/04/26");
assertThat(date).isEqualTo("2003/04/26T00:00:00.000");
assertThat(date).isEqualTo("2003-04-26");
assertThat(date).isEqualTo("2003-04-26T00:00:00");
assertThat(date).isEqualTo("2003-04-26T00:00:00.000");
}
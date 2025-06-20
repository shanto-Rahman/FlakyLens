@DisplayName("anchor: escape text, emphasize, and allow free width") @Test public void anchor2(){
assertThat(anchor.render(TagOutputFormat.html),is("<a sometag='custom&value' href='http://www.schemacrawler.com' align='right'><b><i>display &amp; text</i></b></a>"));
assertThat(anchor.render(TagOutputFormat.text),is("display & text"));
assertThat(anchor.render(TagOutputFormat.tsv),is("display & text"));
}
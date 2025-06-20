@Test public void nameserver_serialization_test() throws Exception {
  final Nameserver nameserver=new Nameserver();
  nameserver.setHandle("handle");
  nameserver.setLdhName("ns1.xn--fo-5ja.example");
  nameserver.setUnicodeName("foo.example");
  nameserver.getStatus().add("active");
  final Nameserver.IpAddresses ipAddresses=new Nameserver.IpAddresses();
  ipAddresses.getIpv4().add("192.0.2.1");
  ipAddresses.getIpv4().add("192.0.2.2");
  ipAddresses.getIpv6().add("2001:db8::123");
  nameserver.setIpAddresses(ipAddresses);
  nameserver.getRemarks().add(new Remark(Lists.newArrayList("She sells sea shells down by the sea shore.","Originally written by Terry Sullivan.")));
  nameserver.getLinks().add(new Link("http://example.net/nameserver/xxxx","self","http://example.net/nameserver/xxxx",null,null));
  nameserver.setPort43("whois.example.net");
  final Event registrationEvent=new Event();
  registrationEvent.setEventAction(Action.REGISTRATION);
  registrationEvent.setEventDate(LOCAL_DATE_TIME);
  nameserver.getEvents().add(registrationEvent);
  final Event lastChangedEvent=new Event();
  lastChangedEvent.setEventAction(Action.LAST_CHANGED);
  lastChangedEvent.setEventDate(LOCAL_DATE_TIME);
  lastChangedEvent.setEventActor("joe@example.com");
  nameserver.getEvents().add(lastChangedEvent);
  assertThat(marshal(nameserver),equalTo("" + "{\n" + "  \"handle\" : \"handle\",\n"+ "  \"ldhName\" : \"ns1.xn--fo-5ja.example\",\n"+ "  \"unicodeName\" : \"foo.example\",\n"+ "  \"ipAddresses\" : {\n"+ "    \"ipv4\" : [ \"192.0.2.1\", \"192.0.2.2\" ],\n"+ "    \"ipv6\" : [ \"2001:db8::123\" ]\n"+ "  },\n"+ "  \"status\" : [ \"active\" ],\n"+ "  \"remarks\" : [ {\n"+ "    \"description\" : [ \"She sells sea shells down by the sea shore.\", \"Originally written by Terry Sullivan.\" ]\n"+ "  } ],\n"+ "  \"links\" : [ {\n"+ "    \"value\" : \"http://example.net/nameserver/xxxx\",\n"+ "    \"rel\" : \"self\",\n"+ "    \"href\" : \"http://example.net/nameserver/xxxx\"\n"+ "  } ],\n"+ "  \"events\" : [ {\n"+ "    \"eventAction\" : \"registration\",\n"+ "    \"eventDate\" : \"" + DATE_TIME + "\"\n"+ "  }, {\n"+ "    \"eventAction\" : \"last changed\",\n"+ "    \"eventDate\" : \""+ DATE_TIME+ "\",\n"+ "    \"eventActor\" : \"joe@example.com\"\n"+ "  } ],\n"+ "  \"port43\" : \"whois.example.net\",\n"+ "  \"objectClassName\" : \"nameserver\"\n"+ "}"));
}

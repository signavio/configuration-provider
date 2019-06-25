package com.signavio.workflow.config;

import java.util.*;

public class ExampleConfigProvider implements ConfigurationProvider {

  @Override
  public Map<String, String> get() {
    return Collections.unmodifiableMap(
        new HashMap<String, String>() {{
          put("effektif.mongodb.password", "test_password");
          put("key", "value");
        }});
  }
}

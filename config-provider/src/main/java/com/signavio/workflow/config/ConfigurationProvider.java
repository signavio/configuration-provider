package com.signavio.workflow.config;

import java.util.Map;

/**
 * Provides a functional interface to define key/value configuration.
 */
public interface ConfigurationProvider {

  /**
   * Provides the configuration details.
   *
   * @return Map with the configuration.
   */
  Map<String, String> get();
}

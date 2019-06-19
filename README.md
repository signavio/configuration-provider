# Configuration Provider

Service Provider Interface (SPI) to define configuration.

## How it works

Provides an interface to allow custom implementations to define key/value configuration entries.

This allows a [Service Loader](https://docs.oracle.com/javase/7/docs/api/java/util/ServiceLoader.html) to pick configuration from remote sources. 

## How to implement it

The custom configuration service provider has to implement the interface `ConfigurationProvider`.
The dependency library can be found [here](https://lmgtfy.com/?q=com.signavio.config-provider) #TODO provide link to maven central repo

## Implementation reference example

Add the dependency to your project.

Maven example:
```
<dependency>
    <groupId>com.signavio</groupId>
    <artifactId>config-provider</artifactId>
    <version>1.0.0</version>
</dependency>
```

Create a class that implements `ConfigurationProvider` and overrides the method `Map<String, String> get()`.

_src/main/java/com/signavio/config/ExampleConfigProvider.java_
```java
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
```

The service provider has to include a file under `META-INF/services`.
The file name should be the fully qualified service name without any extension.
Inside the file the provider has to specify the fully qualified implementation.

_src/main/resources/META-INF/services/com.signavio.config.ConfigurationProvider_
```
com.signavio.config.ExampleConfigProvider
```

## How to deploy it

The generated implementation has to be packed as a `jar` file and copied under `$TOMCAT_HOME/webapps/ROOT/lib` directory.

After that, the application has to be restarted in order for the new configuration service to be applied.

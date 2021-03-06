# nebula.platform

Install Docker plugin
https://www.jetbrains.com/help/idea/docker.html


File > Settings > plugins Enter Docker install

If you are using Docker for Windows
https://www.jetbrains.com/help/idea/docker-connection-settings.html

File -> Settings -> Build, Execution, Deployment 

TCP socket. If you are using Docker for Windows, this is the usual connection option. This option will also work for Linux, Docker for macOS and Docker Toolbox.

Engine API URL. Depending on the Docker version and operating system:
Docker for Windows: tcp://localhost:2375
IMPORTANT! In the General section of your Docker settings, turn on the Expose daemon on tcp://localhost:2375 without TLS option.

Configuring your IDE
IntelliJ IDEA
Delegating build and run actions to Gradle
1.on the main menu select File | Settings | Build, Execution, Deployment |Build Tools |Gradle.
2.Click Gradle and from the drop-down list, select Runner.
3.On the Runner page, select Delegate IDE build/run actions to Gradle.
gradle delegate ide run to gradle
Note that the Run test using option stays active and you can select how you want to run your tests even if you delegated all build and run actions to Gradle.
4.Click OK.

Application “hot restart” with Spring Boot devtools
Spring Boot devtools is configured by JHipster, and will “hot restart” your application when classes from your project are compiled. This is a must-have feature, as it makes your application updated on the fly.

By default IntelliJ IDEA does not automatically compile files when the application is running. To enable the “Compile on save” feature:

Go to File -> Settings -> Build, Execution, Deployment -> Compiler and enable “Build project automatically”
Open the Action window :
Linux : CTRL+SHIFT+A
Mac OSX : SHIFT+COMMAND+A
Windows : CTRL+ALT+SHIFT+/
Enter Registry... and enable compiler.automake.allow.when.app.running

ref:
https://www.jetbrains.com/help/idea/gradle.html#delegate_build_gradle
https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle/#using-boot-devtools-restart
https://www.jhipster.tech/configuring-ide-idea/
# Getting Started
1. Download and install the [V2 Desktop SDK](https://developer.leapmotion.com/sdk/v2) for your OS. I would recommend installing v2.3.1 or the latest release.
2. Clone with git `git clone https://github.com/ConradMearns/leap-sciview.git`
3. Copy `target/lib/LeapJava.jar` into your Fiji plugin directory `<Fiji.app root>/plugins/jars/lib/`
4. Compile with maven
5. Copy `leap-sciview-x.x.x-SNAPSHOT.jar` into `<Fiji.app root>/plugins/jars/`
6. Profit!

__Linux users:__ You may get an error after installing related to /etc/init.d/skeleton. You can ignore this, you just have to launch the service by running `leapd` as root.

# LICENSING

leap-sciview is distributed under a
[Simplified BSD License](http://en.wikipedia.org/wiki/BSD_licenses);
for the full text of the license, see
[LICENSE.txt](https://github.com/imagej/imagej/blob/master/LICENSE.txt).

For the list of ImageJ developers and contributors, see
[the parent POM](https://github.com/imagej/pom-imagej/blob/master/pom.xml).

<!-- ---------------------------------------------

# Maybe useful

[restlessprogrammer](http://www.restlessprogrammer.com/2013/03/developing-for-leap-motion-controller.html)

```mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file \
    -Dfile=PATH_TO_JAR \
    -DgroupId=com.leapmotion.leap -DartifactId=leapMotion \
    -Dversion=1.0.0 -Dpackaging=jar
``` -->

# Camel Router Project for Blueprint (OSGi) with ActiveMQ


## To build this project use

    mvn install

## To run the project you can execute the following Maven goal

    mvn camel:run

To deploy the project in OSGi. For example using Apache ServiceMix
or Apache Karaf. You can run the following command from its shell:

    osgi:install -s mvn:com.sahoora.apache.camel.mq/camel-mq-example/1.0-SNAPSHOT

## Apache Camel archetype
The Apache Camel OSGi archetype creates a project for building a route that can be deployed into the OSGi container. To generate a Maven project with the coordinates, GroupId:ArtifactId:Version, enter the following command:
'''console
mvn archetype:generate \
-DarchetypeGroupId=org.apache.camel.archetypes \
  -DarchetypeArtifactId=camel-archetype-blueprint \
  -DgroupId=com.sahoora.apache.camel.mq \
  -DartifactId=camel-mq-example \
'''
## Configuration in Fuse
-------------------

Prerequisites
----

The camel-activemq feature, which defines the bundles required for the Camel ActiveMQ component, is not installed by default. To install the camel-activemq feature, enter the following console command:
'''console
JBossFuse:karaf@root> features:install camel-activemq
'''
In 6.2 fuse
---
'''console
features:install activemq-camel
'''

  


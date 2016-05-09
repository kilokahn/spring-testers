#Running the spring-jms-batched-listener

### On command line

#### Run the message publisher piece
With an initial delay of 10 seconds, at a fixed delay of 30 seconds, 10 messages are published to the destination. This goes on for a hour by default. Also note the port number on which embedded broker is started. Since we have enabled JMX, you can use your favorite MBeans browser to check the queue sizes and browse messages.

    ./gradlew run

#### Run the message consumer piece

Edit the build.gradle customSystemProperties to modify the port number noted above

##### Vanilla - single message consumption
Modify the customSystemProperty - `spring.profiles.active` to `vanilla`  and run:

    ./gradlew test 

##### Non-Vanilla - bulk message consumption 
Modify the customSystemProperty - `spring.profiles.active` to `non-vanilla` and run:

    ./gradlew test 



### On Eclipse

#### Run the message publisher piece

Use the launchers/SpringJMSBatchedDriver.launch to start the embedded activemq broker. With an initial delay of 10 seconds, at a fixed delay of 30 seconds, 10 messages are published to the destination. This goes on for a hour by default. Also note the port number on which embedded broker is started. Since we have enabled JMX, you can use your favorite MBeans browser to check the queue sizes and browse messages. 

#### Run the message consumer piece

Edit the launcher files to modify the com.kilo.jms.broker.url property to specify the correct port number

##### Vanilla - single message consumption
Use the launchers/MessageListenerTest-vanilla.launch to listen to each of the messages that was sent. 

##### Non-Vanilla - bulk message consumption 
Use the launchers/MessageListenerTest-non-vanilla.launch to listen to each batch of the messages that was sent.
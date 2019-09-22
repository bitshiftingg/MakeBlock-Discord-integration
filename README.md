<h1>MakeBlock Discord Integration (Communicatation systems to allow you to control your makeblock robot via discord)</h1>

This Java library enable communication between a Java application and MakeBlock robots and discord. This is done via the serial port of any computer able to run Java and supports both the wired serial connection as well as a bleutooth serial connection and discord commands allowing users to execute specific commands within the makeblock/scratch framework.

<b>Getting Started</b>

Currently there is no ready made JAR archive availlable. As such, you will need to download and build from the sources. Since this project can be built with Maven, this should not prove to difficult.

<b>Prerequisites</b>

The example uses a MakeBlock script written in mBlock 3.*. The Java code needs Maven to build.

<b>Installing</b>

Install the JDK, minimum should be Java 8. Install Maven, minimum should be Mavan 3.*. Install mBlock3 if you want to be able to run the example script.

Run the Maven in the root of the Java project to download all dependencies: mvn clean install

<b>Running the test script</b>

Open mBlock3, and upload the script to your robot. This script was written for the Ranger. After uploading the script, disconnect the robot from mBlock.

In mBlock 3 verify the serial port the robot is connected to. This port is currently hardcoded into the Java code and my require changing on your system.

In your IDE of choice, open up the example class: RunClient

Edit the serial port to the one found in mBlock in the previous step. This can be done on line 27.

portId.getName().equals("COM3")
Run the RunClient class.

Than proceed to edit the discord bot token and apply your discord bot token.

and then run the Discord.java as the main class.

<b>Explaining the test script</b>

The test script starts by setting up a connection to the robot. Then, it plays a note. This can be used to test if the connection is working. After playing the note, it reads the onboard light sensor. This is done for several seconds. On read every 400 miliseconds. Based on the returned light entensity, the onboard LED's are turned on or of. This can be tested by either covering up the light sensor, or shining a bright light at the light sensor. The light entensity used for turning the light on or off can be found in the LightSensorListener, an inner class in the RunClient, between line 152 and 159.

if (Integer.parseInt(data[1]) < 400) {
    System.out.println("turn on");
    sender.sendCommand(setAllOnboardLEDsSingleColor((byte) 100));
}
if (Integer.parseInt(data[1]) > 900) {
    System.out.println("turn off");
    sender.sendCommand(setAllOnboardLEDsSingleColor((byte) 0));
}
By varying these numbers, you can vary when the lights are turned on, and then they turned off.

The RunClient prints various messages to the console so you can keep track of the progress.

response: SENSOR|LIGHT|306

SENSOR
light intensity: 306
turn on
response: SENSOR|LIGHT|969
  
SENSOR
light intensity: 969
turn off
response: COLOR|PROCESSED
Built With
mBlock - The IDE used to build the makeblock script for the ranger
Maven - Dependency Management

<b>Explaning the discord command System</b>

Implements MessageCreateListener from Javacord's API, Which can be downloaded from their website.
Sending a command to the makeblock frameowrk.

@Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
    	try {
    		Discord.client.getSender().sendCommand(Discord.client.moveForward((byte) 200));
            EmbedBuilder embedBuilder = new EmbedBuilder().
                    setTitle("Robot Forward Movement").setColor(Color.green)
                    .addField("The Robot is now moving", "forward."); 
            messageCreateEvent.getChannel().sendMessage(embedBuilder);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

<b>Authors/People that worked on it.</b>

- Naimur Rahman/https://github.com/adamtrinity

- Mark Schrijver

- HamzaRDM

- Tyluur (5'9 and not jacked fella who helped me find spelling mistakes)


Hope you enjoy using this, hacked this side-project in 3-4 hours hence why the code is slightly messy.

# batcher
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Batcher is to run batch jobs in a non-blocking way through event driven architecture - written in plain java not using any application development framework
##### Core Components
- Batcher 
- Event
- EventQueue
- Event Listener/Consumer
- Job 
- Job Executor
- Memory Watcher

##### TODO
 -- XML mapper of Events and Jobs and Event chaining 
 -- Netty based server and client introducing to run batch jobs in network
 -- EventQueue as a Server
 -- Thread configuration options
 -- Web view to trace progress 
 -- Proper Logger implementation 
 -- More test cases
##### Example Implementation
Generate a file with x number of lines and each line consist of a string that is unique with 100 characters long
##### Run
To run the example implementation just run gradle in project folder in commandline you will must need atleast Java 8. Option 'args' is number of lines to write current limit is 1-229 which is configurable in config.properties file in resources folder. You can find the output in output.txt in project folder.
```sh
>gradlew run --args="2"
```
==========================
```sh
author: manna mahmud
```

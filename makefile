full: #Compile and run
	make compile
	make run
compile: #compile code to ./classes
	javac *.java -d ./classes
run:  #run Main file
	cd ./classes/ && java GameOfLife
clean: #Remove all classes
	cd classes/ && rm *.class

build_tests:
	javac -cp classes:${JUnitLibs} -d classes Test.java

run_tests:
	java -cp classes:${JUnitLibs} junit.textui.TestRunner ExampleTest

test: g1 build_tests run_tests

g1:
	javac -d classes *.java
